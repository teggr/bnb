package com.robintegg.bnb.locale;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ContentLocaleRepository {

	private HashMap<String, ContentLocale> locales;
	private ContentLocale defaualtLocale;

	public ContentLocaleRepository() {
		locales = new HashMap<>();
		defaualtLocale = new ContentLocale(Locale.GERMAN);
		locales.put(Locale.GERMAN.getLanguage(), defaualtLocale);
		locales.put(Locale.ENGLISH.getLanguage(), new ContentLocale(Locale.ENGLISH));
	}

	public Optional<ContentLocale> findByDefaultLocale(boolean defaultLocale) {
		return Optional.of(defaualtLocale);
	}

	public Optional<ContentLocale> findByLocale(Locale locale) {
		return Optional.ofNullable(locales.get(locale.getLanguage()));
	}

	public Collection<ContentLocale> findAll() {
		return locales.values();
	}

	public void save(ContentLocale contentLocale) {
		// TODO Auto-generated method stub

	}

}
