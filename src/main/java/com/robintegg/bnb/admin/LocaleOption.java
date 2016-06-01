package com.robintegg.bnb.admin;

import java.util.Locale;

public class LocaleOption {

	private String code;
	private String language;
	private boolean defaultLocale;

	public LocaleOption(Locale Locale, boolean defaultLocale) {
		this.defaultLocale = defaultLocale;
		this.code = Locale.getLanguage();
		this.language = Locale.getDisplayLanguage();
	}

	public String getCode() {
		return code;
	}

	public String getLanguage() {
		return language;
	}

	public boolean isDefault() {
		return defaultLocale;
	}

}
