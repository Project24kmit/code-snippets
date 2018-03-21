package com.pmp.elements;

public class User {

	private String name;
	private Credentials credentials;
	private ContactDetails contactDetails;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}
}
