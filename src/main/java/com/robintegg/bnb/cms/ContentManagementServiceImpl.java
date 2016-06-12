package com.robintegg.bnb.cms;

import java.util.Locale;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.robintegg.bnb.locale.LocaleService;
import com.robintegg.bnb.lodging.ContactForm;
import com.robintegg.bnb.lodging.SingleLodgingService;

@Service
@Transactional
public class ContentManagementServiceImpl implements ContentManagementService {

	private SingleLodgingService singleLodgingService;
	private PageRepository pageRepository;
	private LocaleService localeService;
	private PageTemplateRepository templateRepository;

	@Autowired
	public ContentManagementServiceImpl(SingleLodgingService singleLodgingService, PageRepository pageRepository,
			LocaleService localeService, PageTemplateRepository templateRepository) {
		this.singleLodgingService = singleLodgingService;
		this.pageRepository = pageRepository;
		this.localeService = localeService;
		this.templateRepository = templateRepository;
	}

	@Override
	public ModelAndView getHomePage(Locale locale) {
		ModelMap model = new ModelMap();

		model.addAttribute("navigation",
				Navigation.newInstance(pageRepository, localeService.getDefaultLocale(), locale));

		model.addAttribute("lodging", singleLodgingService.getLodging());

		Page page = pageRepository.findByHome(true);

		model.addAttribute("model", new PageModel(page));

		String template = page.getTemplate();

		PageTemplate pageTemplate = templateRepository.findByName(template);
		pageTemplate.loadForms(model);

		return new ModelAndView(template, model);
	}

	@Override
	public ModelAndView getPage(String path, Locale locale) {
		ModelMap model = new ModelMap();

		model.addAttribute("navigation",
				Navigation.newInstance(pageRepository, localeService.getDefaultLocale(), locale));

		model.addAttribute("lodging", singleLodgingService.getLodging());

		Page page = pageRepository.findByTitleSlug(path);

		model.addAttribute("model", new PageModel(page));

		String template = page.getTemplate();

		PageTemplate pageTemplate = templateRepository.findByName(template);
		pageTemplate.loadForms(model);

		return new ModelAndView(template, model);
	}

	@Override
	public ModelAndView processContactForm(ContactForm contactForm, String path, Locale locale) {

		// pass onto the form service
		singleLodgingService.registerContact(contactForm);

		return new ModelAndView("redirect:" + path);
	}

}
