package com.pmp.services;

import static com.pmp.sql.SQLQueries.DELETE_PRODUCT_BY_PRODUCTID;
import static com.pmp.sql.SQLQueries.SELECT_ALL_PRODUCTS;
import static com.pmp.sql.SQLQueries.SELECT_ALL_PRODUCTS_BY_DEALERID;
import static com.pmp.sql.SQLQueries.UPDATE_PRODUCT_BY_PRODUCTID;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pmp.elements.Product;

public class ProductService {
	private Connection dbconnection;

	public ProductService(Connection dbconnection) {
		this.dbconnection = dbconnection;
	}

	public List<Product> getAllProducts() {
		List<Product> allProducts = new ArrayList<Product>();
		try {
			PreparedStatement preparedStatement = dbconnection.prepareStatement(SELECT_ALL_PRODUCTS);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs != null && rs.next()) {
				Product product = new Product();
				product.setCategoryId(rs.getInt("categoryId"));
				product.setCost(rs.getFloat("cost"));
				product.setDealerId(rs.getInt("dealerId"));
				product.setProductDescription(rs.getString("description"));
				product.setProductId(rs.getInt("productId"));
				product.setImageFilePath(rs.getString("image"));
				product.setProductName(rs.getString("name"));
				product.setStockQuantity(rs.getInt("stock"));
				allProducts.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allProducts;
	}

	public List<Product> getAllProductsByDealerId(int dealerId) {
		List<Product> allProducts = new ArrayList<Product>();
		try {
			PreparedStatement preparedStatement = dbconnection.prepareStatement(SELECT_ALL_PRODUCTS_BY_DEALERID);
			preparedStatement.setInt(1, dealerId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs != null && rs.next()) {
				Product product = new Product();
				product.setCategoryId(rs.getInt("categoryId"));
				product.setCost(rs.getFloat("cost"));
				product.setDealerId(rs.getInt("dealerId"));
				product.setProductDescription(rs.getString("description"));
				product.setProductId(rs.getInt("productId"));
				product.setImageFilePath(rs.getString("image"));
				product.setProductName(rs.getString("name"));
				product.setStockQuantity(rs.getInt("stock"));
				allProducts.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allProducts;
	}

	public void updateProduct(int productId, Product product) {
		try {
			PreparedStatement preparedStatement = dbconnection.prepareStatement(UPDATE_PRODUCT_BY_PRODUCTID);
			preparedStatement.setString(1, product.getProductName());
			preparedStatement.setInt(2, product.getCategoryId());
			preparedStatement.setString(3, product.getProductDescription());
			preparedStatement.setFloat(4, product.getCost());
			preparedStatement.setInt(5, product.getStockQuantity());
			preparedStatement.setInt(6, productId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteProduct(int productId) {
		try {
			PreparedStatement preparedStatement = dbconnection.prepareStatement(DELETE_PRODUCT_BY_PRODUCTID);
			preparedStatement.setInt(1, productId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
