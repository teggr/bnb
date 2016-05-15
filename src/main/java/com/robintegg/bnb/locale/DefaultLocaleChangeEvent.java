package com.robintegg.bnb.locale;

import org.springframework.context.ApplicationEvent;

public class DefaultLocaleChangeEvent extends ApplicationEvent {

	private static final long serialVersionUID = 8804140727754417470L;

	private ContentLocale defaultLocale;

	public DefaultLocaleChangeEvent(LocaleService localeService, ContentLocale defaultLocale) {
		super(localeService);
		this.defaultLocale = defaultLocale;
	}

	public ContentLocale getDefaultLocale() {
		return defaultLocale;
	}
}
