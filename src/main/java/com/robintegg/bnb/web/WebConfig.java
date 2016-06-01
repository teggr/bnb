package com.robintegg.bnb.web;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.messageresolver.SpringMessageResolver;

import com.robintegg.bnb.locale.LocaleService;

@Configuration
public class WebConfig {

	@Bean
	public FilterRegistrationBean someFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(localeFilter());
		registration.addUrlPatterns("/*");
		registration.setName("localeInPathFilter");
		return registration;
	}

	@Bean
	public Filter localeFilter() {
		return new LocaleUrlFilter();
	}

	@Bean
	public CustomLocaleResolver localeResolver(LocaleService localeService) {
		return new CustomLocaleResolver(localeService);
	}

	@Autowired
	public void addCustomThymeleafMessageResolvers(TemplateEngine engine, MessageSource messageSource) {
		engine.addMessageResolver(new CmsPageModelMessageResolver());
		final SpringMessageResolver springMessageResolver = new SpringMessageResolver();
		springMessageResolver.setMessageSource(messageSource);
		engine.addMessageResolver(springMessageResolver);
	}

}
