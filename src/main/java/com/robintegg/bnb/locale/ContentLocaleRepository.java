package com.robintegg.bnb.locale;

import java.util.Locale;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentLocaleRepository extends JpaRepository<ContentLocale, Long> {

	Optional<ContentLocale> findByDefaultLocale(boolean defaultLocale);
	
	Optional<ContentLocale> findByLocale(Locale locale);

}
