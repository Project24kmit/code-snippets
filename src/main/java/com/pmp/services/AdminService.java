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


public class AdminService {

	public boolean login(String id,String pwd) {
		return id.equals("100") && pwd.equals("100");
	}

	public List<Dealer> dealerRequestList (Connection dbconnection) {
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

	public boolean rejectRequest(Connection dbconnection,int requestId) {
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

	private boolean sendMail(int dealerId,String password,Connection dbconnection) {
		try{
				PreparedStatement stmt = dbconnection.prepareStatement(GET_DEALER_MAIL);
				stmt.setInt(1,dealerId);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					String mailID = rs.getString(1);
					// mail code
				}
				return true;
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		return false;
	}

	private boolean updateDealerDetails(int requestId, int dealerId,String password,Connection dbconnection) {
		try{
				PreparedStatement stmt = dbconnection.prepareStatement(UPDATE_DEALER_DETAILS);
				stmt.setInt(1,dealerId);
				stmt.setInt(2,requestId);
				stmt.executeUpdate();
				return sendMail(dealerId,password,dbconnection);
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		return false;
	}

	public boolean acceptRequest(Connection dbconnection,int requestId) {
		try{
				PreparedStatement stmt = dbconnection.prepareStatement(INSERT_DEALER);
				stmt.setInt(1,requestId);
				stmt.setString(2,getPassword()+"");
				stmt.executeUpdate();
				stmt = dbconnection.prepareStatement(GET_INSERTED_DEALER_RECORD);
				stmt.setInt(1,requestId);
				ResultSet rs = stmt.executeQuery();	
				if (rs.next()) {
					return updateDealerDetails(requestId,rs.getInt(1),rs.getString(2),dbconnection);
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		return false;
	}	

	public boolean unregisterDealer(Connection dbconnection,int dealerId) {
		try{
				PreparedStatement stmt = dbconnection.prepareStatement(UNREGISTER_DEALER);
				stmt.setInt(1,dealerId);
				stmt.executeUpdate();
				return true;
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		return false;
	}

	public Dealer getDealerRecord(Connection dbconnection,int dealerId) {
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
					// get the list of products product service
					Product p1 = new Product();
					Product p2 = new Product();
					Product p3 = new Product();
					Product p4 = new Product();
					p1.setProductName("prod1");
					p2.setProductName("prod2");
					p3.setProductName("prod3");
					p4.setProductName("prod4");
					
					List<Product> list = new ArrayList();
					list.add(p1);
					list.add(p2);
					list.add(p3);
					list.add(p4);
					dealer.setProducts(list);

					return dealer;
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		return null;
	}

	public List<Dealer> getDealers (Connection dbconnection) {
		List<Dealer> dealerList = new ArrayList();
		try{
				ResultSet rs = dbconnection.prepareStatement(GET_ALL_DEALER_IDS).executeQuery();
				while(rs.next())
				{
					Dealer dealer = getDealerRecord(dbconnection,rs.getInt(1));
					dealerList.add(dealer);
				}
				return dealerList;
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		return null;
	}

	private int getPassword(){
		Random rand = new Random();
		int  pwd = rand.nextInt(50000) + 10000;
		return pwd;
	}
}
