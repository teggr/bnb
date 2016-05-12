package com.robintegg.bnb;

import java.nio.charset.Charset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.robintegg.bnb.utils.MessageSourceChain;
import com.robintegg.bnb.utils.SiteMessageSource;

@SpringBootApplication
public class Bnb2Application {

	public static void main(String[] args) {
		SpringApplication.run(Bnb2Application.class, args);
	}
	
	@Primary
	@Bean
	public MessageSource messageSourceChain() {
		return new MessageSourceChain(siteMessageSource(), messageSource());
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("messages");
		messageSource.setDefaultEncoding(Charset.forName("UTF-8").name());
		messageSource.setCacheSeconds(-1);
		messageSource.setAlwaysUseMessageFormat(true);
		return messageSource;
	}

	@Bean
	public MessageSource siteMessageSource() {
		return new SiteMessageSource();
	}

}
