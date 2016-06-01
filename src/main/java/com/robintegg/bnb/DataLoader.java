package com.robintegg.bnb;

import java.util.Locale;

import javax.transaction.Transactional;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.robintegg.bnb.cms.Page;
import com.robintegg.bnb.cms.PageRepository;
import com.robintegg.bnb.core.Address;
import com.robintegg.bnb.core.EmailAddress;
import com.robintegg.bnb.core.PhoneNumber;
import com.robintegg.bnb.core.Title;
import com.robintegg.bnb.locale.LocaleService;
import com.robintegg.bnb.lodging.GoogleMap;
import com.robintegg.bnb.lodging.Lodging;
import com.robintegg.bnb.lodging.LodgingName;

@Configuration
public class DataLoader {

	@Bean
	public ApplicationRunner loadData(PageRepository pageRepository, LocaleService localeService) {
		return new ApplicationRunner() {

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

		};
	}

	@Bean
	public Lodging lodging() {
		return Lodging.newInstance(LodgingName.newInstance("Pension Moosholz"),
				Address.newInstance("Pension Moosholz", "Moosholzweg 4", "D-38678", "Deutschland", ""),
				PhoneNumber.newInstance("01234 555555"), PhoneNumber.newInstance("01234 666666"),
				EmailAddress.newInstance("pension-moosholz@mail.de"),
				GoogleMap.newInstance(
						"https://www.google.co.uk/maps/place/Moosholzweg+4,+38678+Clausthal-Zellerfeld,+Germany/@51.7765777,10.3320373,15z/data=!4m7!1m4!3m3!1s0x47a53b794f1a9479:0x440af30bbcb240e9!2sMoosholzweg+4,+38678+Clausthal-Zellerfeld,+Germany!3b1!3m1!1s0x47a53b794f1a9479:0x440af30bbcb240e9",
						""));
	}

}
