package com.robintegg.bnb.contact;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.robintegg.bnb.email.EmailMessage;

public class ContactFormEmail implements EmailMessage {

	private String from;
	private String subject;
	private String message;

	public ContactFormEmail(ContactForm contactForm) {
		this.from = contactForm.getEmail();
		this.subject = createSubject(contactForm);
		this.message = contactForm.getMessage();
	}

	private String createSubject(ContactForm contactForm) {
		return contactForm.getName() + " " + DateFormatUtils.format(contactForm.getDate(), "dd/MM/yyyy hh:mm");
	}

	@Override
	public String from() {
		return from;
	}

	@Override
	public String subject() {
		return subject;
	}

	@Override
	public String message() {
		return message;
	}

}
