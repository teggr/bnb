package com.robintegg.bnb.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robintegg.bnb.email.EmailService;

@Service
public class ContactServiceImpl implements ContactService {

	private EmailService emailService;

	@Autowired
	public ContactServiceImpl(EmailService emailService) {
		this.emailService = emailService;
	}

	@Override
	public void registerContact(ContactForm contactForm) {


		// send email
		emailService.send(new ContactFormEmail(contactForm));

		// save form

	}

}
