package com.pmp.elements;

public class Product {

	private int productId;
	private int categoryId;
	private String productName;
	private String productDescription;
	private Double cost;
	private int stockQuantity;

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductId() {
		return productId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getCost() {
		return cost;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}
}
