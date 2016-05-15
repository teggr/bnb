package com.robintegg.bnb.locale;

import java.util.Collection;

import org.springframework.context.ApplicationEvent;

public class RegisteredLocaleChangeEvent extends ApplicationEvent {

	private static final long serialVersionUID = 95844284501570892L;
	private Collection<ContentLocale> registeredLocales;

	public RegisteredLocaleChangeEvent(LocaleService localeService, Collection<ContentLocale> registeredLocales) {
		super(localeService);
		this.registeredLocales = registeredLocales;
	}

	public Collection<ContentLocale> getRegisteredLocales() {
		return registeredLocales;
	}
}
