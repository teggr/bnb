package com.robintegg.bnb.lodging;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.robintegg.bnb.email.EmailMessage;

public class ContactFormEmail implements EmailMessage {

	private String from;
	private String subject;
	private String message;
	private String to;

	public ContactFormEmail(ContactForm contactForm, Lodging lodging) {
		this.from = contactForm.getEmail();
		this.subject = createSubject(lodging);
		this.message = createMessage(contactForm);
		this.to = lodging.getEmail().getAddress();
	}

	private String createMessage(ContactForm contactForm) {
		return String.format("At: %s\n\n%s sent you a message:\n\n%s",
				new Object[] { DateFormatUtils.format(contactForm.getDate(), "dd/MM/yyyy HH:mm"), contactForm.getName(),
						contactForm.getMessage() });
	}

	private String createSubject(Lodging lodging) {
		return "Message from " + lodging.getName().getName();
	}

	@Override
	public String to() {
		return to;
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
