package com.pmp.services;

import static com.pmp.sql.SQLQueries.*;

import com.pmp.elements.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.sql.Date;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;  
import java.util.HashMap;

public class AdminService {
	private Connection dbconnection;
	private ProductService productService;

	public AdminService(Connection dbconnection) {
		this.dbconnection = dbconnection;
		this.productService = new ProductService(dbconnection);
	}

	public boolean login(String id,String pwd) {
		return id.equals("100") && pwd.equals("100");
	}

	public List<Dealer> dealerRequestList () {
		List<Dealer> requestList = new ArrayList();

		try{
			ResultSet rs = dbconnection.prepareStatement(GET_REQUESTS).executeQuery();
			while(rs.next())
				{
					Dealer request = new Dealer();
					ContactDetails contactDetails = new ContactDetails();
					request.setRequestId(rs.getInt("requestId"));
					request.setName(rs.getString("name"));
					contactDetails.setContactNumber(rs.getString("mobile"));
					contactDetails.setAddress(rs.getString("area"));
					contactDetails.setMailId(rs.getString("email"));
					request.setContactDetails(contactDetails);
					requestList.add(request);
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		return requestList;
	}

	public boolean rejectRequest(int requestId) {
		try{
			PreparedStatement stmt = dbconnection.prepareStatement(DELETE_REQUEST);
			stmt.setInt(1,requestId);
			stmt.executeUpdate();
			return true;
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		return false;
	}

	private boolean sendMail(int dealerId,String password) {
		try{
				PreparedStatement stmt = dbconnection.prepareStatement(GET_DEALER_MAIL);
				stmt.setInt(1,dealerId);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					String dealerMailID = rs.getString(1);
					String senderMailID = "project24.kmit@gmail.com";
					String pwd = "Project24kmit123";
					String subject = "Admin response";
					String msg = "Your DealerId ="+dealerId+" and the password = "+password;
					
					Properties props = new Properties();
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.port", "587");		
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.starttls.enable", "true");
					
					Session session = Session.getInstance(props,new javax.mail.Authenticator()
				    {
				  	   protected PasswordAuthentication getPasswordAuthentication() 
				  	   {
				  	  	 return new PasswordAuthentication(senderMailID,pwd);
				  	   }
				    });

			       MimeMessage message = new MimeMessage(session);
			       message.setFrom(new InternetAddress(senderMailID));
			       message.addRecipient(Message.RecipientType.TO,new InternetAddress(dealerMailID));
			       message.setSubject(subject);
			       message.setText(msg);

			       /* Transport class is used to deliver the message to the recipients */
			       
			       Transport.send(message);
				}
				return true;
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return false;
	}

	private boolean updateDealerDetails(int requestId, int dealerId,String password) {
		try{
				PreparedStatement stmt = dbconnection.prepareStatement(UPDATE_DEALER_DETAILS);
				stmt.setInt(1,dealerId);
				stmt.setInt(2,requestId);
				stmt.executeUpdate();
				return sendMail(dealerId,password);
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		return false;
	}

	public boolean acceptRequest(int requestId) {
		try{
				PreparedStatement stmt = dbconnection.prepareStatement(INSERT_DEALER);
				stmt.setInt(1,requestId);
				stmt.setString(2,getPassword()+"");
				stmt.executeUpdate();
				stmt = dbconnection.prepareStatement(GET_INSERTED_DEALER_RECORD);
				stmt.setInt(1,requestId);
				ResultSet rs = stmt.executeQuery();	
				if (rs.next()) {
					return updateDealerDetails(requestId,rs.getInt(1),rs.getString(2));
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		return false;
	}	

	public boolean unregisterDealer(int dealerId, String reason) {
		try{
				Dealer dealer = getDealerRecord(dealerId);
				if(dealer==null)
					return false;
				PreparedStatement stmt = dbconnection.prepareStatement(UNREGISTER_DEALER);
				stmt.setInt(1,dealerId);
				stmt.executeUpdate();
				stmt = dbconnection.prepareStatement(STORE_EX_DEALER);
				stmt.setInt(1,dealer.getCredentials().getUsername());
				stmt.setDate(2,new Date((new java.util.Date().getTime())));
				stmt.setString(3,dealer.getName());
				stmt.setString(4,dealer.getContactDetails().getAddress());
				stmt.setString(5,dealer.getContactDetails().getMailId());
				stmt.setString(6,dealer.getContactDetails().getContactNumber());
				stmt.setString(7,reason);
				stmt.executeUpdate();
				return true;
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		return false;
	}

	public Dealer getDealerRecord(int dealerId) {
		try{
				PreparedStatement stmt = dbconnection.prepareStatement(GET_DEALER);
				stmt.setInt(1,dealerId);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					Dealer dealer =  new Dealer();
					Credentials credentials = new Credentials();
					ContactDetails contactDetails = new ContactDetails();

					credentials.setUsername(rs.getInt("dealerId"));
					dealer.setName(rs.getString("name"));
					contactDetails.setContactNumber(rs.getString("mobile"));
					contactDetails.setAddress(rs.getString("area"));
					contactDetails.setMailId(rs.getString("email"));
					dealer.setContactDetails(contactDetails);
					dealer.setCredentials(credentials);
					dealer.setProducts(productService.getAllProductsByDealerId(dealerId));
					return dealer;
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		return null;
	}

	public List<Dealer> getDealers () {
		List<Dealer> dealerList = new ArrayList();
		try{
				ResultSet rs = dbconnection.prepareStatement(GET_ALL_DEALER_IDS).executeQuery();
				while(rs.next())
				{
					Dealer dealer = getDealerRecord(rs.getInt(1));
					dealerList.add(dealer);
				}
				return dealerList;
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		return null;
	}

	public List<Order> getOverallSales() {
		List<Order> salesList = new ArrayList();
		try {
			PreparedStatement preparedStmt = dbconnection.prepareStatement(GET_OVERALL_SALES_FOR_ADMIN);
			ResultSet rs =	preparedStmt.executeQuery();
			while(rs.next())
			{
				Order order = new Order();
				order.setDealerId(rs.getInt(1));
				order.setQuantity(rs.getInt(2));
				salesList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salesList;	
	}

	public List<Order> getSalesDataPerDealer(int dealerId)
	{

		List<Order> salesList = new ArrayList();
		try {
			PreparedStatement preparedStmt = dbconnection.prepareStatement(GET_DEALER_SALES_FOR_ADMIN);
			preparedStmt.setInt(1, dealerId);
			ResultSet rs =	preparedStmt.executeQuery();
			while(rs.next())
			{
				Order order = new Order();
				order.setDate(getMonth(rs.getString(1)));
				order.setQuantity(rs.getInt(2));
				salesList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salesList;	
	}


	private int getPassword(){
		Random rand = new Random();
		int  pwd = rand.nextInt(50000) + 10000;
		return pwd;
	}

	private String getMonth(String date)
	{
		String month=date.split("-")[0];
		HashMap<String,String> hm = new HashMap();
		hm.put("01","JAN");hm.put("03","MAR");hm.put("05","MAY");hm.put("07","JULY");hm.put("09","SEP");hm.put("11","NOV");
		hm.put("02","FEB");hm.put("04","APR");hm.put("06","JUN");hm.put("08","AUG");hm.put("10","OCT");hm.put("12","DEC");
		return hm.get(month);
	}
}

