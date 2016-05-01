package com.robintegg.bnb.admin;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import com.robintegg.bnb.core.Address;
import com.robintegg.bnb.core.EmailAddress;
import com.robintegg.bnb.core.PhoneNumber;
import com.robintegg.bnb.db.BaseEntity;

@Entity
public class AccountSettings extends BaseEntity {

	@Embedded
	EmailAddress emailAddress = new EmailAddress();

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "number", column = @Column(name = "telephone_number") ) })
	PhoneNumber telephoneNumber = new PhoneNumber();

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "number", column = @Column(name = "mobile_number") ) })
	PhoneNumber mobileNumber = new PhoneNumber();

	String facebookLink = "";

	String tripAdvisorLink = "";

	@Embedded
	Address address = new Address();

	public EmailAddress getEmailAddress() {
		return emailAddress;
	}

	public PhoneNumber getTelephoneNumber() {
		return telephoneNumber;
	}

	public PhoneNumber getMobileNumber() {
		return mobileNumber;
	}

	public String getFacebookLink() {
		return facebookLink;
	}

	public String getTripAdvisorLink() {
		return tripAdvisorLink;
	}

	public Address getAddress() {
		return address;
	}

}
