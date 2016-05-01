package com.robintegg.bnb.admin;

import java.util.ArrayList;
import java.util.List;

public class AccountSettingsUpdate {

	private String emailAddress;
	private String telephoneNumber;
	private String mobileNumber;
	private String facebookLink;
	private String tripAdvisorLink;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String addressLine4;
	private String addressLine5;

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFacebookLink() {
		return facebookLink;
	}

	public void setFacebookLink(String facebookLink) {
		this.facebookLink = facebookLink;
	}

	public String getTripAdvisorLink() {
		return tripAdvisorLink;
	}

	public void setTripAdvisorLink(String tripAdvisorLink) {
		this.tripAdvisorLink = tripAdvisorLink;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getAddressLine4() {
		return addressLine4;
	}

	public void setAddressLine4(String addressLine4) {
		this.addressLine4 = addressLine4;
	}

	public String getAddressLine5() {
		return addressLine5;
	}

	public void setAddressLine5(String addressLine5) {
		this.addressLine5 = addressLine5;
	}

	@Override
	public String toString() {
		return "AccountUpdate [emailAddress=" + emailAddress + ", telephoneNumber=" + telephoneNumber
				+ ", mobileNumber=" + mobileNumber + ", facebookLink=" + facebookLink + ", tripAdvisorLink="
				+ tripAdvisorLink + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", addressLine3=" + addressLine3 + ", addressLine4=" + addressLine4 + ", addressLine5=" + addressLine5
				+ "]";
	}

}
