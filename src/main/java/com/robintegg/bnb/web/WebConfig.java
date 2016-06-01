package com.robintegg.bnb.web;

import javax.servlet.Filter;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
	public FixedCustomLocaleResolver localeResolver(LocaleService localeService) {
		return new FixedCustomLocaleResolver(localeService);
	}

}
