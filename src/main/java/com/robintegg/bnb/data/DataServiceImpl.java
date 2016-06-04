package com.robintegg.bnb.data;

import java.util.Locale;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.robintegg.bnb.lodging.LodgingRepository;

@Transactional
@Service
public class DataServiceImpl implements DataService {

	private PageRepository pageRepository;
	private LocaleService localeService;
	private LodgingRepository lodgingRepository;
	private DataLoadRepository dataLoadRepository;

	@Autowired
	public DataServiceImpl(PageRepository pageRepository, LodgingRepository lodgingRepository,
			LocaleService localeService, DataLoadRepository dataLoadRepository) {
		this.pageRepository = pageRepository;
		this.lodgingRepository = lodgingRepository;
		this.localeService = localeService;
		this.dataLoadRepository = dataLoadRepository;
	}

	@Override
	public void prePopulate() {

		if (isNotPrepopulated()) {

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

			// load lodging
			lodgingRepository.save(Lodging.newInstance(LodgingName.newInstance("Pension Moosholz"),
					Address.newInstance("Pension Moosholz", "Moosholzweg 4", "D-38678", "Deutschland", ""),
					PhoneNumber.newInstance("01234 555555"), PhoneNumber.newInstance("01234 666666"),
					EmailAddress.newInstance("pension-moosholz@mail.de"),
					GoogleMap.newInstance(
							"https://www.google.co.uk/maps/place/Moosholzweg+4,+38678+Clausthal-Zellerfeld,+Germany/@51.7765777,10.3320373,15z/data=!4m7!1m4!3m3!1s0x47a53b794f1a9479:0x440af30bbcb240e9!2sMoosholzweg+4,+38678+Clausthal-Zellerfeld,+Germany!3b1!3m1!1s0x47a53b794f1a9479:0x440af30bbcb240e9",
							"")));

			dataLoadRepository.save(new DataLoad(DataLoad.Type.PRE_POPULATION));

		}

	}

	private boolean isNotPrepopulated() {
		return dataLoadRepository.count() == 0;
	}

}
