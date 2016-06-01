package com.robintegg.bnb.locale;

import java.util.Collection;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocaleServiceImpl implements LocaleService {
	
	private static final Logger log = LoggerFactory.getLogger(LocaleServiceImpl.class);

	private static final Locale DEFAULT_LOCALE = Locale.ENGLISH;

	private LocaleConfigurationRepository localeRepository;

	@Autowired
	public LocaleServiceImpl(LocaleConfigurationRepository localeRepository) {
		this.localeRepository = localeRepository;
	}

	@Override
	public boolean isDefaultLocale(Locale locale) {
		return getDefaultLocale().equals(locale);
	}

	@Override
	public void setDefaultLocale(Locale locale) {		
		log.info("Setting default locale {}", locale);
		// does it need to be a registered locale. probably ...

		Optional<LocaleConfiguration> currentDefault = localeRepository.findByDefaultLocale(true);
		if (currentDefault.isPresent()) {
			currentDefault.get().setDefaultLocale(false);
		}

		Optional<LocaleConfiguration> targetLocale = localeRepository.findByLanguage(locale.getLanguage());
		if (targetLocale.isPresent()) {
			LocaleConfiguration contentLocale = targetLocale.get();
			contentLocale.setDefaultLocale(true);
		}

		// what if that locale wasn't there?

	}

	@Override
	public Locale getDefaultLocale() {
		Optional<LocaleConfiguration> currentDefault = localeRepository.findByDefaultLocale(true);
		if (currentDefault.isPresent()) {
			return currentDefault.get().toLocale();
		}
		return DEFAULT_LOCALE;
	}

	@Override
	public Collection<Locale> getLocales() {
		return localeRepository.findAll().stream().map(r -> r.toLocale()).collect(Collectors.toList());
	}

	@Override
	public void registerLocale(Locale locale) {		
		log.info("Registering locale {}", locale);
		localeRepository.save(new LocaleConfiguration(locale));
	}

	@Override
	public boolean isRegisteredLanguageCode(String languageCode) {
		return localeRepository.findByLanguage(languageCode).isPresent();
	}

	@Override
	public boolean isRegisteredCountryCode(String countryCode) {
		return localeRepository.findByCountry(countryCode).isPresent();
	}

}
