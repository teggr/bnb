package com.robintegg.bnb.core;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.StringUtils;

@Embeddable
public class PhoneNumber {

	public static PhoneNumber newInstance(String number) {
		assert StringUtils.isNotEmpty(number);
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.number = number;
		return phoneNumber;
	}

	String number;
	
	PhoneNumber() {}

	public String getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "PhoneNumber [number=" + number + "]";
	}

}
