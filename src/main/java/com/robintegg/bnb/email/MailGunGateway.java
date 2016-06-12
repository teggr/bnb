package com.robintegg.bnb.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailGunGateway implements EmailService {

	private static final Logger log = LoggerFactory.getLogger(MailGunGateway.class);

	private static final String DEFAULT_TO_ADDRESS = "robin@tegg.me.uk"; // "mail@pension-moosholz.de";
	private JavaMailSender mailSender;

	@Autowired
	public MailGunGateway(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void send(EmailMessage message) {

		log.debug("Sending to {}");
		log.debug("Sending from {}", message.from());
		log.debug("With subject {}", message.subject());
		log.debug("And message {}", message.message());

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(DEFAULT_TO_ADDRESS);
		msg.setFrom(message.from());
		msg.setSubject(message.subject());
		msg.setText(message.message());

		try {
			mailSender.send(msg);
		} catch (Exception e) {
			System.err.println(e);
		}

	}

}
