package com.pmp.services;

import static com.pmp.sql.SQLQueries.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class UserService {

	public boolean isUserValid(int userId, String password, Connection dbconnection) {
		try {
			ResultSet rs = dbconnection.prepareStatement(SELECT_FROM_USER_TABLE).executeQuery();
			while (rs.next()) {
				if (rs.getInt("userId") == userId && rs.getString("password").equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public int insertUserDetails(String firstName,String lastName,String address,String mobile,String email,String password, Connection dbconnection){
		try{
			PreparedStatement stmt = dbconnection.prepareStatement(INSERT_INTO_USER_DETAILS);
			stmt.setString(1,password);
			stmt.setString(2,firstName+" "+lastName);
			stmt.setString(3,email);
			stmt.setString(4,mobile);
			stmt.setString(5,address);
			stmt.executeUpdate();
			ResultSet rs = dbconnection.prepareStatement(GET_USER_ID).executeQuery();
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
