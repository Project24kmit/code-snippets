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


public class UserService {
	private Connection dbconnection;

	public UserService(Connection dbconnection) {
		this.dbconnection = dbconnection;
	}

	public List<Order> getAllOrders(int userId) {
		List<Order> orderList = new ArrayList();
		try{
			PreparedStatement stmt = dbconnection.prepareStatement(GET_USER_ORDERS);
			stmt.setInt(1,userId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
				{
					Product product = new Product();
					product.setProductId(rs.getInt(3));
					PreparedStatement pstmt = dbconnection.prepareStatement(GET_PRODUCT_DETAIL);
					pstmt.setInt(1,product.getProductId());
					ResultSet ps = pstmt.executeQuery();
					if(ps.next())
					{
						product.setProductName(ps.getString(1));
						product.setProductDescription(ps.getString(2));
						product.setCost(ps.getFloat(3));
						product.setImageFilePath("../uploadFiles/10_sharpner.jpg");
					}
					Order order = new Order();
					order.setTransactionId(rs.getInt(1));
					order.setUserId(rs.getInt(2));
					order.setProduct(product);
					order.setQuantity(rs.getInt(4));
					order.setTotal(order.getQuantity()*order.getProduct().getCost());

					orderList.add(order);
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		return orderList;
	}

	public void deleteTransaction(int transactionId)
	{
		try{
			PreparedStatement stmt = dbconnection.prepareStatement(DELETE_TRANSACTION);
			stmt.setInt(1,transactionId);
			stmt.executeUpdate();
		}
		catch(SQLException e){
				e.printStackTrace();
		}
	}

	public void updateTransaction(int transactionId,int quantity)
	{
		try{
			PreparedStatement stmt = dbconnection.prepareStatement(UPDATE_TRANSACTION);
			stmt.setInt(1,quantity);
			stmt.setInt(2,transactionId);
			stmt.executeUpdate();
		}
		catch(SQLException e){
				e.printStackTrace();
		}
	}	
}
