package com.robintegg.bnb.locale;

import java.util.Collection;
import java.util.Locale;

/**
 * @author r_tegg
 *
 *         Locale specific to the content being delivered
 */
public interface LocaleService {

	void setDefaultLocale(Locale locale);

	Locale getDefaultLocale();

	boolean isDefaultLocale(Locale locale);

	Collection<Locale> getLocales();

	void registerLocale(Locale locale);

	boolean isRegisteredLanguageCode(String languageCode);

	boolean isRegisteredCountryCode(String countryCode);

}
