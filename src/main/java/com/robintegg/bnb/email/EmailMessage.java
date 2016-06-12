package com.robintegg.bnb.email;

public interface EmailMessage {

	String from();
	String subject();
	String message();
	String to();
	
}
