package com.robintegg.bnb.locale;

import java.util.Collection;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.robintegg.bnb.core.DomainEventPublisher;

public class LocaleServiceImpl implements LocaleService {

	private ContentLocaleRepository localeRepository;
	private DomainEventPublisher domainEventPublisher;

	@Autowired
	public LocaleServiceImpl(ContentLocaleRepository localeRepository, DomainEventPublisher domainEventPublisher) {
		this.localeRepository = localeRepository;
		this.domainEventPublisher = domainEventPublisher;
	}

	@Override
	public void updateDefaultLocale(Locale locale) {

		// does it need to be a registered locale. probably ...

		Optional<ContentLocale> currentDefault = localeRepository.findByDefaultLocale(true);
		if (currentDefault.isPresent()) {
			currentDefault.get().setDefaultLocale(false);
		}

		Optional<ContentLocale> targetLocale = localeRepository.findByLocale(locale);
		if (targetLocale.isPresent()) {
			ContentLocale contentLocale = targetLocale.get();
			contentLocale.setDefaultLocale(true);
			domainEventPublisher.publishEvent(new DefaultLocaleChangeEvent(this, contentLocale));
		}
		
		// what if that locale wasn't there?


	}

	@Override
	public Collection<ContentLocale> getRegisteredLocales() {
		return localeRepository.findAll();
	}

	@Override
	public void registerLocale(Locale locale, boolean makeDefault) {
		localeRepository.save(new ContentLocale(locale));

		domainEventPublisher.publishEvent(new RegisteredLocaleChangeEvent(this, getRegisteredLocales()));

		if (makeDefault) {
			updateDefaultLocale(locale);
		}
	}

}
