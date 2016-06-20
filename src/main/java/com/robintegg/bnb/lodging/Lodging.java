package com.robintegg.bnb.lodging;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import org.apache.commons.lang3.StringUtils;

import com.robintegg.bnb.core.Address;
import com.robintegg.bnb.core.EmailAddress;
import com.robintegg.bnb.core.PhoneNumber;
import com.robintegg.bnb.db.BaseEntity;

@Entity
public class Lodging extends BaseEntity {

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

	@Embedded
	private LodgingName name;
	@Embedded
	private Address address;

	@AttributeOverrides({ @AttributeOverride(name = "number", column = @Column(name = "landline") ), })
	@Embedded
	private PhoneNumber landline;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "number", column = @Column(name = "mobile") ), })
	private PhoneNumber mobile;
	@Embedded
	private EmailAddress email;
	@Embedded
	private GoogleMap map;

	Lodging() {
	}

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
	
	public void update( LodgingForm form ) {
		
		if(StringUtils.isNotBlank(form.getName())) {
			name = LodgingName.newInstance(form.getName());
		}
		if(StringUtils.isNotBlank(form.getLandline())) {
			landline = PhoneNumber.newInstance(form.getLandline());
		}
		if(StringUtils.isNotBlank(form.getMobileNumber())) {
			mobile = PhoneNumber.newInstance(form.getMobileNumber());
		}
		if(StringUtils.isNotBlank(form.getEmailAddress())) {
			email = EmailAddress.newInstance(form.getEmailAddress());
		}
		address = Address.newInstance(form.getAddressLine1(), form.getAddressLine2(), form.getAddressLine3(), form.getAddressLine4(), form.getAddressLine5());
		map = GoogleMap.newInstance(form.getMapUrl(), form.getMapImage());
		
	}

	@Override
	public String toString() {
		return "Lodging [name=" + name + ", address=" + address + ", landline=" + landline + ", mobile=" + mobile
				+ ", email=" + email + ", map=" + map + "]";
	}

}
