package com.robintegg.bnb.locale;

import java.util.Locale;

import javax.persistence.Entity;

import com.robintegg.bnb.db.BaseEntity;

@Entity
class LocaleConfiguration extends BaseEntity {

	private String language;
	private boolean defaultLocale = false;
	private String country;

	LocaleConfiguration() {
	}

	public LocaleConfiguration(Locale locale) {
		this.language = locale.getLanguage();
		this.country = locale.getCountry();
	}

	public Locale toLocale() {
		return new Locale(language, country);
	}

	public boolean isDefaultLocale() {
		return defaultLocale;
	}

	public void setDefaultLocale(boolean defaultLocale) {
		this.defaultLocale = defaultLocale;
	}

}
