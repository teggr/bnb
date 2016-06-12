package com.robintegg.bnb.cms;

import java.util.Locale;

import org.springframework.web.servlet.ModelAndView;

import com.robintegg.bnb.lodging.ContactForm;

public interface ContentManagementService {

	ModelAndView getHomePage(Locale locale);

	ModelAndView getPage(String path, Locale locale);

	ModelAndView processContactForm(ContactForm contactForm, String path, Locale locale);

}
