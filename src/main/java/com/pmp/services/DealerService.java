package com.pmp.services;

import static com.pmp.sql.SQLQueries.GET_REQUEST_ID;
import static com.pmp.sql.SQLQueries.INSERT_INTO_CATEGORY_TABLE;
import static com.pmp.sql.SQLQueries.INSERT_INTO_DEALER_DETAILS;
import static com.pmp.sql.SQLQueries.INSERT_INTO_PRODUCT_TABLE;
import static com.pmp.sql.SQLQueries.SELECT_DEALER_BY_DEALERID;
import static com.pmp.sql.SQLQueries.SELECT_FROM_DEALER_TABLE;
import static com.pmp.sql.SQLQueries.UPDATE_DEALER_BY_DEALERID;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pmp.elements.ContactDetails;
import com.pmp.elements.Dealer;
import com.pmp.elements.Product;

public class DealerService {
	private Connection dbconnection;

	public DealerService(Connection dbconnection) {
		this.dbconnection = dbconnection;
	}

	public boolean isDealerValid(int userId, String password) {
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

	public void addNewCategory(String categoryName, int dealerId) {
		try {
			PreparedStatement preparedStmt = dbconnection.prepareStatement(INSERT_INTO_CATEGORY_TABLE);
			preparedStmt.setString(1, categoryName);
			preparedStmt.setInt(2, dealerId);
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addNewProduct(Product product) {
		try {
			PreparedStatement preparedStmt = dbconnection.prepareStatement(INSERT_INTO_PRODUCT_TABLE);
			preparedStmt.setInt(1, product.getDealerId());
			preparedStmt.setString(2, product.getProductName());
			preparedStmt.setInt(3, product.getCategoryId());
			preparedStmt.setString(4, product.getProductDescription());
			preparedStmt.setFloat(5, product.getCost());
			preparedStmt.setInt(6, product.getStockQuantity());
			preparedStmt.setString(7, product.getImageFilePath());

			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int insertDealerDetails(Dealer dealer) {
		try {
			PreparedStatement stmt = dbconnection.prepareStatement(INSERT_INTO_DEALER_DETAILS);
			stmt.setInt(1, -1);
			stmt.setString(2, dealer.getName());
			stmt.setString(3, dealer.getContactDetails().getAddress());
			stmt.setString(4, dealer.getContactDetails().getMailId());
			stmt.setString(5, dealer.getContactDetails().getContactNumber());
			stmt.setString(6, dealer.getCompany());
			stmt.executeUpdate();
			ResultSet rs = dbconnection.prepareStatement(GET_REQUEST_ID).executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public Dealer getDealerByDealerId(int dealerId) {
		Dealer dealer = new Dealer();
		try {
			PreparedStatement preparedStmt = dbconnection.prepareStatement(SELECT_DEALER_BY_DEALERID);
			preparedStmt.setInt(1, dealerId);
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				dealer.setName(rs.getString("name"));
				dealer.setCompany(rs.getString("company"));
				ContactDetails contactDetails = new ContactDetails();
				contactDetails.setAddress(rs.getString("area"));
				contactDetails.setContactNumber(rs.getString("mobile"));
				contactDetails.setMailId(rs.getString("email"));
				dealer.setContactDetails(contactDetails);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dealer;
	}

	public void updateDealerDetails(int dealerId, Dealer dealer) {
		try {
			PreparedStatement preparedStmt = dbconnection.prepareStatement(UPDATE_DEALER_BY_DEALERID);
			preparedStmt.setString(1, dealer.getName());
			preparedStmt.setString(2, dealer.getContactDetails().getAddress());
			preparedStmt.setString(3, dealer.getContactDetails().getMailId());
			preparedStmt.setString(4, dealer.getContactDetails().getContactNumber());
			preparedStmt.setInt(5, dealerId);
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
