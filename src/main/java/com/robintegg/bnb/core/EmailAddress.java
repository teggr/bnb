package com.robintegg.bnb.core;

import javax.persistence.Embeddable;

@Embeddable
public class EmailAddress {

	public static EmailAddress newInstance(String emailAddress) {
		EmailAddress address = new EmailAddress();
		address.emailAddress = emailAddress;
		return address;
	}

	String emailAddress;

	public String getEmailAddress() {
		return emailAddress;
	}

	@Override
	public String toString() {
		return "EmailAddress [emailAddress=" + emailAddress + "]";
	}

}
