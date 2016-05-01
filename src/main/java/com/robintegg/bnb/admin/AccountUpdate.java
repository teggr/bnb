package com.robintegg.bnb.admin;

public class AccountUpdate {

	private String emailAddress;

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	@Override
	public String toString() {
		return "AccountUpdate [emailAddress=" + emailAddress + "]";
	}

}
