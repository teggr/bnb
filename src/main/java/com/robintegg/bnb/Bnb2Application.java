package com.robintegg.bnb;

import java.nio.charset.Charset;
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.context.support.StaticMessageSource;

import com.robintegg.bnb.utils.MessageSourceChain;

@SpringBootApplication
public class Bnb2Application {

	public static void main(String[] args) {
		SpringApplication.run(Bnb2Application.class, args);
	}
	
	@Primary
	@Bean
	public MessageSource messageSource() {
		return new MessageSourceChain(staticMessageSource(), resourceBundleMessageSource());
	}

	@Bean
	public ResourceBundleMessageSource resourceBundleMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("messages");
		messageSource.setDefaultEncoding(Charset.forName("UTF-8").name());
		messageSource.setCacheSeconds(-1);
		messageSource.setAlwaysUseMessageFormat(true);
		return messageSource;
	}

	@Bean
	public StaticMessageSource staticMessageSource() {
		StaticMessageSource source = new StaticMessageSource();
		
		source.addMessage("home.nav", Locale.GERMAN, "vielen danke");
		source.addMessage("suites.nav", Locale.GERMAN, "suiten");
		source.addMessage("reservations.nav", Locale.GERMAN, "reserviet");
		source.addMessage("contact.nav", Locale.GERMAN, "contacten");
		
		source.addMessage("home.nav", Locale.ENGLISH, "home");
		source.addMessage("suites.nav", Locale.ENGLISH, "Suites");
		source.addMessage("reservations.nav", Locale.ENGLISH, "Reservations");
		source.addMessage("contact.nav", Locale.ENGLISH, "Contact Us");
		
		return source;
	}

}
