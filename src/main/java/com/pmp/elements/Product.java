package com.pmp.elements;

public class Product {

	private int productId;
	private int categoryId;
	private int dealerId;
	private String productName;
	private String productDescription;
	private Float cost;
	private int stockQuantity;
	private String imageFilePath;

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

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	public int getDealerId() {
		return dealerId;
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

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public Float getCost() {
		return cost;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}
}

