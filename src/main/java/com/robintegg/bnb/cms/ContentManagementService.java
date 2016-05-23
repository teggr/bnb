package com.robintegg.bnb.cms;

import java.util.Locale;

import org.springframework.web.servlet.ModelAndView;

public interface ContentManagementService {

	ModelAndView getHomePage(Locale locale);

	ModelAndView getPage(String path, Locale locale);

}
