package com.robintegg.bnb.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.LocaleResolver;

import com.robintegg.bnb.locale.LocaleService;

public class FixedCustomLocaleResolver implements LocaleResolver {

	private LocaleService localeService;

	public FixedCustomLocaleResolver(LocaleService localeService) {
		this.localeService = localeService;
	}

	@Override
	public Locale resolveLocale(HttpServletRequest servletRequest) {
		final String countryCode = (String) servletRequest.getAttribute(LocaleUrlFilter.COUNTRY_CODE_ATTRIBUTE_NAME);
		if (isSupportedCountyCode(countryCode)) {
			String languageCode = (String) servletRequest.getAttribute(LocaleUrlFilter.LANGUAGE_CODE_ATTRIBUTE_NAME);
			if (isSupportedLanguageCode(languageCode)) {
				return new Locale(languageCode, countryCode);
			} else {
				return new Locale(countryCode);
			}
		}
		return localeService.getDefaultLocale();
	}

	private boolean isSupportedLanguageCode(String languageCode) {
		return languageCode != null
				&& localeService.isRegisteredLanguageCode(languageCode);
	}

	private boolean isSupportedCountyCode(String countryCode) {
		return countryCode != null && localeService.isRegisteredCountryCode(countryCode);
	}

	@Override
	public void setLocale(final HttpServletRequest servletRequest, final HttpServletResponse servletResponse,
			final Locale locale) {
		throw new UnsupportedOperationException();
	}

}