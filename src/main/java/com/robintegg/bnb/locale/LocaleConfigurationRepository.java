package com.robintegg.bnb.locale;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocaleConfigurationRepository extends JpaRepository<LocaleConfiguration, Long> {

	Optional<LocaleConfiguration> findByDefaultLocale(boolean defaultLocale);

	Optional<LocaleConfiguration> findByLanguage(String language);

	Optional<LocaleConfiguration> findByCountry(String country);

}
