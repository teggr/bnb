package com.robintegg.bnb.web;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.context.event.EventListener;

import com.robintegg.bnb.locale.ContentLocale;
import com.robintegg.bnb.locale.DefaultLocaleChangeEvent;
import com.robintegg.bnb.locale.FixedCustomLocaleResolver;
import com.robintegg.bnb.locale.RegisteredLocaleChangeEvent;

public class LocaleWatcher {

	private FixedCustomLocaleResolver localeResolver;

	public LocaleWatcher(FixedCustomLocaleResolver localeResolver) {
		this.localeResolver = localeResolver;
	}

	@EventListener
	public void onDefaultLocaleChangeEvent(DefaultLocaleChangeEvent event) {

		ContentLocale defaultLocale = event.getDefaultLocale();

		localeResolver.setDefaultLocale(defaultLocale.getLocale());

	}

	@EventListener
	public void onRegisteredLocaleChangeEvent(RegisteredLocaleChangeEvent event) {

		Collection<ContentLocale> locales = event.getRegisteredLocales();

		localeResolver.setSupportedCountryCodes(
				locales.stream().map(c -> c.getLocale().getCountry()).collect(Collectors.toSet()));

	}

}
