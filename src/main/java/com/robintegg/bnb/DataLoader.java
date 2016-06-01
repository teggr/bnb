package com.robintegg.bnb;

import java.util.Locale;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.robintegg.bnb.cms.Page;
import com.robintegg.bnb.cms.PageRepository;
import com.robintegg.bnb.core.Title;
import com.robintegg.bnb.locale.LocaleService;

@Component
public class DataLoader implements ApplicationRunner {

	private PageRepository pageRepository;
	private LocaleService localeService;

	@Autowired
	public DataLoader(PageRepository pageRepository, LocaleService localeService) {
		this.pageRepository = pageRepository;
		this.localeService = localeService;
	}

	@Transactional
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		// register locales
		localeService.registerLocale(Locale.UK);
		localeService.registerLocale(Locale.GERMANY);
		localeService.setDefaultLocale(Locale.UK);

		// load pages
		pageRepository.save(new Page.Builder("general", new Title("Home")).makeHome().build());
		pageRepository.save(new Page.Builder("general", new Title("Harz Mountains")).build());
		pageRepository.save(new Page.Builder("rooms", new Title("Suites")).build());
		pageRepository.save(new Page.Builder("booking", new Title("Reservations")).build());
		pageRepository.save(new Page.Builder("contact", new Title("Contact Us")).build());

	}

}
