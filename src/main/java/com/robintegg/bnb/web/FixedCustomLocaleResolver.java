package com.robintegg.bnb.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.LocaleResolver;

public class FixedCustomLocaleResolver implements LocaleResolver {

	private Locale defaultLocale = Locale.getDefault();

	public void setDefaultLocale(Locale defaultLocale) {
		this.defaultLocale = defaultLocale;
	}

	@Override
	public Locale resolveLocale(HttpServletRequest servletRequest) {
		final String countryCode = (String) servletRequest.getAttribute(LocaleUrlFilter.COUNTRY_CODE_ATTRIBUTE_NAME);
		if (countryCode != null) {
			String languageCode = (String) servletRequest.getAttribute(LocaleUrlFilter.LANGUAGE_CODE_ATTRIBUTE_NAME);
			if (languageCode == null) {
				return new Locale(countryCode);
			}
			return new Locale(languageCode, countryCode);
		}
		return defaultLocale;
	}

	@Override
	public void setLocale(final HttpServletRequest servletRequest, final HttpServletResponse servletResponse,
			final Locale locale) {
		throw new UnsupportedOperationException();
	}

}