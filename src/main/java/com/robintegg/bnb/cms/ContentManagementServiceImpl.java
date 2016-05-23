package com.robintegg.bnb.cms;

import java.util.Locale;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.robintegg.bnb.locale.LocaleService;
import com.robintegg.bnb.lodging.SingleLodgingService;

@Service
@Transactional
public class ContentManagementServiceImpl implements ContentManagementService {

	private SingleLodgingService singleLodgingService;
	private PageRepository pageRepository;
	private LocaleService localeService;

	@Autowired
	public ContentManagementServiceImpl(SingleLodgingService singleLodgingService, PageRepository pageRepository,
			LocaleService localeService) {
		this.singleLodgingService = singleLodgingService;
		this.pageRepository = pageRepository;
		this.localeService = localeService;
	}

	@Override
	public ModelAndView getHomePage(Locale locale) {
		ModelMap model = new ModelMap();

		model.addAttribute("navigation",
				Navigation.newInstance(pageRepository, localeService.getDefaultLocale(), locale));

		model.addAttribute("lodging", singleLodgingService.getLodging());

		return new ModelAndView("home", model);
	}

	@Override
	public ModelAndView getPage(String path, Locale locale) {
		ModelMap model = new ModelMap();

		model.addAttribute("navigation",
				Navigation.newInstance(pageRepository, localeService.getDefaultLocale(), locale));

		model.addAttribute("lodging", singleLodgingService.getLodging());

		return new ModelAndView(pageRepository.findByName(path).getTemplate(), model);
	}

}
