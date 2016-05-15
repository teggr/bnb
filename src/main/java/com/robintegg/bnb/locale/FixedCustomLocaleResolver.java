package com.robintegg.bnb.locale;

import java.util.Collections;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.LocaleResolver;

public class FixedCustomLocaleResolver implements LocaleResolver {

	private Locale defaultLocale = Locale.getDefault();

	private Set<String> supportedCountryCodes = Collections.emptySet();

	private Set<String> supportedLanguageCodes = Collections.emptySet();

	public void setDefaultLocale(Locale defaultLocale) {
		this.defaultLocale = defaultLocale;
	}

	public void setSupportedCountryCodes(Set<String> supportedCountryCodes) {
		this.supportedCountryCodes = supportedCountryCodes;
	}

	public void setSupportedLanguageCodes(Set<String> supportedLanguageCodes) {
		this.supportedLanguageCodes = supportedLanguageCodes;
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
		return defaultLocale;
	}

	private boolean isSupportedLanguageCode(String languageCode) {
		return languageCode != null
				&& (supportedLanguageCodes.isEmpty() || supportedLanguageCodes.contains(languageCode));
	}

	private boolean isSupportedCountyCode(String countryCode) {
		return countryCode != null && (supportedCountryCodes.isEmpty() || supportedCountryCodes.contains(countryCode));
	}

	@Override
	public void setLocale(final HttpServletRequest servletRequest, final HttpServletResponse servletResponse,
			final Locale locale) {
		throw new UnsupportedOperationException();
	}

}