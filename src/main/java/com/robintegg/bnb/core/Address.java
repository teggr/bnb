package com.robintegg.bnb.core;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	public static Address newInstance(String addressLine1, String addressLine2, String addressLine3,
			String addressLine4, String addressLine5) {
		Address address = new Address();
		address.addressLine1 = addressLine1 != null ? addressLine1 : "";
		address.addressLine2 = addressLine2 != null ? addressLine2 : "";
		address.addressLine3 = addressLine3 != null ? addressLine3 : "";
		address.addressLine4 = addressLine4 != null ? addressLine4 : "";
		address.addressLine5 = addressLine5 != null ? addressLine5 : "";
		return address;
	}

	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String addressLine4;
	private String addressLine5;

	Address() {
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public String getAddressLine4() {
		return addressLine4;
	}

	public String getAddressLine5() {
		return addressLine5;
	}

	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", addressLine3="
				+ addressLine3 + ", addressLine4=" + addressLine4 + ", addressLine5=" + addressLine5 + "]";
	}

}
