package com.pmp.services;

import static com.pmp.sql.SQLQueries.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DealerService {

	public boolean isDealerValid(int userId, String password, Connection dbconnection) {
		try {
			ResultSet rs = dbconnection.prepareStatement(SELECT_FROM_DEALER_TABLE).executeQuery();
			while (rs.next()) {
				if (rs.getInt("dealerId") == userId && rs.getString("password").equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public int insertDealerDetails(String firstName,String lastName,String address,String mobile,String email, Connection dbconnection){
		try{
			PreparedStatement stmt = dbconnection.prepareStatement(INSERT_INTO_DEALER_DETAILS);
			stmt.setInt(1,-1);
			stmt.setString(2,firstName+" "+lastName);
			stmt.setString(3,address);
			stmt.setString(4,email);
			stmt.setString(5,mobile);
			stmt.executeUpdate();
			ResultSet rs = dbconnection.prepareStatement(GET_REQUEST_ID).executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;	
	}

}
