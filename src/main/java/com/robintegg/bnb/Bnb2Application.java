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
		source.addMessage("home", Locale.GERMAN, "vielen danke");
		return source;
	}

}
