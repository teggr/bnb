package com.robintegg.bnb.core;

//@Embeddable
public class EmailAddress {

	public static EmailAddress newInstance(String address) {
		EmailAddress emailAddress = new EmailAddress();
		emailAddress.address = address;
		return emailAddress;
	}

	private String address;

	EmailAddress() {
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "EmailAddress [address=" + address + "]";
	}

}
