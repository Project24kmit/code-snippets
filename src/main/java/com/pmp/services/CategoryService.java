package com.pmp.services;

import static com.pmp.sql.SQLQueries.SELECT_ALL_CATEGORIES;
import static com.pmp.sql.SQLQueries.SELECT_CATEGORY_BY_CATEGORYNAME;
import static com.pmp.sql.SQLQueries.SELECT_CATEGORY_BY_DEALERID;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pmp.elements.Category;

public class CategoryService {
	private Connection dbconnection;

	public CategoryService(Connection dbconnection) {
		this.dbconnection = dbconnection;
	}

	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<Category>();
		try {
			PreparedStatement preparedStatement = dbconnection.prepareStatement(SELECT_ALL_CATEGORIES);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs != null && rs.next()) {
				Category category = new Category();
				category.setCategoryId(rs.getInt("categoryId"));
				category.setCategoryName(rs.getString("name"));
				category.setDealerId(rs.getInt("dealerId"));
				categories.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	public List<Category> getAllCategoriesByDealerId(int dealerId) {
		List<Category> categories = new ArrayList<Category>();
		try {
			PreparedStatement preparedStatement = dbconnection.prepareStatement(SELECT_CATEGORY_BY_DEALERID);
			preparedStatement.setInt(1, dealerId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs != null && rs.next()) {
				Category category = new Category();
				category.setCategoryId(rs.getInt("categoryId"));
				category.setCategoryName(rs.getString("name"));
				category.setDealerId(rs.getInt("dealerId"));
				categories.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	public int getCategoryIdByCategoryName(String categoryName) {
		try {
			PreparedStatement preparedStatement = dbconnection.prepareStatement(SELECT_CATEGORY_BY_CATEGORYNAME);
			preparedStatement.setString(1, categoryName);
			ResultSet rs = preparedStatement.executeQuery();
			int categoryId = 0;
			while (rs != null && rs.next()) {
				categoryId = rs.getInt("categoryId");
			}
			return categoryId;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
