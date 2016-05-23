package com.robintegg.bnb.lodging;

import com.robintegg.bnb.core.Address;
import com.robintegg.bnb.core.EmailAddress;
import com.robintegg.bnb.core.PhoneNumber;

public class Lodging {

	public static Lodging newInstance(LodgingName name, Address address, PhoneNumber landline, PhoneNumber mobile,
			EmailAddress email, GoogleMap map) {
		Lodging lodging = new Lodging();
		lodging.name = name;
		lodging.address = address;
		lodging.landline = landline;
		lodging.mobile = mobile;
		lodging.email = email;
		lodging.map = map;
		return lodging;
	}

	private LodgingName name;
	private Address address;
	private PhoneNumber landline;
	private PhoneNumber mobile;
	private EmailAddress email;
	private GoogleMap map;
	
	Lodging() {}
	
	public Address getAddress() {
		return address;
	}
	
	public EmailAddress getEmail() {
		return email;
	}
	
	public PhoneNumber getLandline() {
		return landline;
	}
	
	public GoogleMap getMap() {
		return map;
	}
	
	public PhoneNumber getMobile() {
		return mobile;
	}
	
	public LodgingName getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Lodging [name=" + name + ", address=" + address + ", landline=" + landline + ", mobile=" + mobile
				+ ", email=" + email + ", map=" + map + "]";
	}

}
