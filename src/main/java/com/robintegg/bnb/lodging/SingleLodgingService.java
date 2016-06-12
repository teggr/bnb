package com.robintegg.bnb.lodging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robintegg.bnb.email.EmailService;

@Service
public class SingleLodgingService {

	private LodgingRepository lodgingRepository;
	private EmailService emailService;

	@Autowired
	public SingleLodgingService(LodgingRepository lodgingRepository, EmailService emailService) {
		this.lodgingRepository = lodgingRepository;
		this.emailService = emailService;
	}

	public Lodging getLodging() {
		return lodgingRepository.findAll().stream().findFirst().get();
	}

	public void registerContact(ContactForm contactForm) {

		// send email
		emailService.send(new ContactFormEmail(contactForm, getLodging()));

		// save form

	}

}
