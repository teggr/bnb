package com.robintegg.bnb.core;

import javax.persistence.Embeddable;

@Embeddable
public class PhoneNumber {

	public static PhoneNumber newInstance(String number) {
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.number = number;
		return phoneNumber;
	}

	String number;

	public String getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "PhoneNumber [number=" + number + "]";
	}

}
