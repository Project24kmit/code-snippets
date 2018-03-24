package com.pmp.elements;

import java.util.List;

public class Order {

	private int transactionId;
	private int userId;
	private int dealerId;
	private float total;
	private int quantity;	
	private Product product;
	private String date;

	public void setDate(String date)
	{
		this.date = date;
	}

	public String getDate()
	{
		return date;
	}
	

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	public int getDealerId() {
		return dealerId;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getTotal() {
		return total;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setProduct(Product product){
		this.product = product;
	}

	public Product getProduct(){
		return product;
	}
	
}
