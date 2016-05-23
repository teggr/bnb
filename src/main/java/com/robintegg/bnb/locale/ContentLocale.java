package com.robintegg.bnb.locale;

import java.util.Locale;

import com.robintegg.bnb.db.BaseEntity;

public class ContentLocale extends BaseEntity {

	private Locale locale;
	private boolean defaultLocale = false;

	ContentLocale() {
	}

	public ContentLocale(Locale locale) {
		this.locale = locale;
	}

	public Locale getLocale() {
		return locale;
	}

	public boolean isDefaultLocale() {
		return defaultLocale;
	}

	public void setDefaultLocale(boolean defaultLocale) {
		this.defaultLocale = defaultLocale;
	}

}
