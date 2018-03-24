package com.pmp.elements;

import java.util.List;

public class Category {

	private int categoryId;
	private int dealerId;	
	private String categoryName;
	private List<Product> products;

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	public int getDealerId() {
		return dealerId;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}
}
