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
import java.util.HashMap;

public class graphService {
	private Connection dbconnection;
	HashMap<String,String> hm = new HashMap();

	public graphService(Connection dbconnection) {
		this.dbconnection = dbconnection;
		hm.put("01","JAN");hm.put("03","MAR");hm.put("05","MAY");hm.put("07","JULY");hm.put("09","SEP");hm.put("11","NOV");
		hm.put("02","FEB");hm.put("04","APR");hm.put("06","JUN");hm.put("08","AUG");hm.put("10","OCT");hm.put("12","DEC");
	}

	public List<Product> getSalesData(int dealerId)
	{
		List<Product> salesList = new ArrayList();
		try {
			PreparedStatement preparedStmt = dbconnection.prepareStatement(GET_DEALER_SALES_DATA);
			preparedStmt.setInt(1, dealerId);
			ResultSet rs =	preparedStmt.executeQuery();
			while(rs.next())
			{
				Product product = new Product();
				product.setProductName(rs.getString(1));
				product.setStockQuantity(rs.getInt(2));
				salesList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salesList;
	}

	public List<Product> getDateWiseSalesData(int dealerId,String date)
	{
		List<Product> salesList = new ArrayList();
		try {
			PreparedStatement preparedStmt = dbconnection.prepareStatement(GET_DATEWISE_DEALER_SALES_DATA);
			preparedStmt.setInt(1, dealerId);
			preparedStmt.setString(2,date);
			ResultSet rs =	preparedStmt.executeQuery();
			while(rs.next())
			{
				Product product = new Product();
				product.setProductName(rs.getString(1));
				product.setStockQuantity(rs.getInt(2));
				salesList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salesList;	
	}

	public List<Order> getAnnualSalesData(int dealerId,int productId)
	{

		List<Order> salesList = new ArrayList();
		try {
			PreparedStatement preparedStmt = dbconnection.prepareStatement(GET_ANNUAL_DEALER_SALES_DATA);
			preparedStmt.setInt(1, dealerId);
			preparedStmt.setInt(2,productId);
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

	private String getMonth(String date)
	{
		String month=date.split("-")[0];
		return hm.get(month);
	}
}
