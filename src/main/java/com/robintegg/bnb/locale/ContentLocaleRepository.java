package com.robintegg.bnb.locale;

import java.util.Locale;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentLocaleRepository extends JpaRepository<ContentLocale, Long> {

	ContentLocale findByDefaultLocale(boolean defaultLocale);
	
	ContentLocale findByLocale(Locale locale);
	
	boolean existsByLocale(Locale locale);

}
