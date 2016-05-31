package com.robintegg.bnb.cms;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContentController {

	private static final Logger log = LoggerFactory.getLogger(ContentController.class);

	private ContentManagementService cms;

	@Autowired
	public ContentController(ContentManagementService cms) {
		this.cms = cms;
	}

	@RequestMapping(path = { "/" }, method = RequestMethod.GET)
	public ModelAndView getHome(Locale locale) {
		log.debug("Getting {}:{}", "/", locale.getLanguage());
		return cms.getHomePage(locale);
	}

	@RequestMapping(value = "/{page}", method = RequestMethod.GET)
	public ModelAndView getPage(@PathVariable(value = "page") String path, Locale locale) {
		log.debug("Getting {}:{}", path, locale.getLanguage());
		return cms.getPage(slug(path), locale);
	}

	private String slug(String path) {
		return "/" + path;
	}

}
