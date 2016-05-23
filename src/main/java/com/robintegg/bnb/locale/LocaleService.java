package com.robintegg.bnb.locale;

import java.util.Collection;
import java.util.Locale;

public interface LocaleService {

	void updateDefaultLocale(Locale locale);
	
	Collection<ContentLocale> getRegisteredLocales();
	
	void registerLocale(Locale locale, boolean makeDefault);

	Locale getDefaultLocale();
	
}
