package com.robintegg.bnb.contact;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

public class ContactForm {

	@NotBlank(message="contact.email.error")
	private String email;
	
	@NotBlank(message="contact.name.error")
	private String name;
	
	@NotBlank(message="contact.message.error")
	private String message;
	
	private Date date = new Date();
	
	public Date getDate() {
		return date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ContactForm [email=" + email + ", name=" + name + ", message=" + message + "]";
	}


}
