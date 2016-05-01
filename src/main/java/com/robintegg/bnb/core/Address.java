package com.robintegg.bnb.core;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	public static Address newInstance(String addressLine1, String addressLine2, String addressLine3, String addressLine4,
			String addressLine5) {
		Address address = new Address();
		address.addressLine1 = addressLine1;
		address.addressLine2 = addressLine2;
		address.addressLine3 = addressLine3;
		address.addressLine4 = addressLine4;
		address.addressLine5 = addressLine5;
		return address;
	}

	String addressLine1;
	String addressLine2;
	String addressLine3;
	String addressLine4;
	String addressLine5;

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
