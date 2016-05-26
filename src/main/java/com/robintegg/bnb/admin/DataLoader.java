package com.robintegg.bnb.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.robintegg.bnb.cms.Page;
import com.robintegg.bnb.cms.PageRepository;
import com.robintegg.bnb.core.Title;

@Component
public class DataLoader implements ApplicationRunner {

	private PageRepository pageRepository;

	@Autowired
	public DataLoader(PageRepository pageRepository) {
		this.pageRepository = pageRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		pageRepository.save(new Page.Builder("general", new Title("Home")).makeHome().build());
		pageRepository.save(new Page.Builder("general", new Title("Harz Mountains")).build());
		pageRepository.save(new Page.Builder("rooms", new Title("Suites")).build());
		pageRepository.save(new Page.Builder("booking", new Title("Reservations")).build());
		pageRepository.save(new Page.Builder("contact", new Title("Contact Us")).build());

	}

}
