package com.pmp.elements;

import java.util.List;

public class Dealer extends User {

	private int requestId;
	private List<Category> categories;
	private List<Product> products;

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getRequestId() {
		return requestId;
	}

}
