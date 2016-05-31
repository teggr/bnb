package com.robintegg.bnb.web;

import java.util.Locale;

import javax.servlet.Filter;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.robintegg.bnb.locale.FixedCustomLocaleResolver;
import com.robintegg.bnb.locale.LocaleUrlFilter;

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
	public FixedCustomLocaleResolver localeResolver() {
		FixedCustomLocaleResolver resolver = new FixedCustomLocaleResolver();
		resolver.setDefaultLocale(Locale.ENGLISH);
		return resolver;
	}

	@Bean
	public LocaleWatcher localeWatcher(FixedCustomLocaleResolver localeResolver) {
		return new LocaleWatcher(localeResolver);
	}

}
