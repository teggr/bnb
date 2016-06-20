package com.robintegg.bnb.lodging;

public class LodgingForm {

	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String addressLine4;
	private String addressLine5;
	private String emailAddress;
	private String landline;
	private String mapImage;
	private String mapUrl;
	private String mobileNumber;
	private String name;

	public LodgingForm(Lodging lodging) {
		
		addressLine1 = lodging.getAddress().getAddressLine1();
		addressLine2 = lodging.getAddress().getAddressLine2();
		addressLine3 = lodging.getAddress().getAddressLine3();
		addressLine4 = lodging.getAddress().getAddressLine4();
		addressLine5 = lodging.getAddress().getAddressLine5();
		emailAddress = lodging.getEmail().getAddress();
		landline = lodging.getLandline().getNumber();
		mapImage = lodging.getMap().getImage();
		mapUrl = lodging.getMap().getUrl();
		mobileNumber = lodging.getMobile().getNumber();
		name = lodging.getName().getName();
		
	}
	
	public LodgingForm() {
		
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getLandline() {
		return landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public String getMapImage() {
		return mapImage;
	}

	public void setMapImage(String mapImage) {
		this.mapImage = mapImage;
	}

	public String getMapUrl() {
		return mapUrl;
	}

	public void setMapUrl(String mapUrl) {
		this.mapUrl = mapUrl;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "LodgingForm [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", addressLine3="
				+ addressLine3 + ", addressLine4=" + addressLine4 + ", addressLine5=" + addressLine5 + ", emailAddress="
				+ emailAddress + ", landline=" + landline + ", mapImage=" + mapImage + ", mapUrl=" + mapUrl
				+ ", mobileNumber=" + mobileNumber + ", name=" + name + "]";
	}
	
	

}
