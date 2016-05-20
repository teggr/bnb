package com.robintegg.bnb.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.robintegg.bnb.admin.Account;
import com.robintegg.bnb.admin.AccountSettings;
import com.robintegg.bnb.cms.Navigation;
import com.robintegg.bnb.cms.Page;
import com.robintegg.bnb.cms.PageRepository;

@Controller
public class HomeController {

	private Account account;
	private PageRepository pages;

	@Autowired
	public HomeController(Account account, PageRepository pages) {
		this.account = account;
		this.pages = pages;
	}

	@ModelAttribute("settings")
	public AccountSettings getSettings() {
		return account.getSettings();
	}

	@ModelAttribute("navigation")
	public Navigation getNavigation() {
		return new Navigation(pages, null);
	}

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String getHome(ModelMap model) {
		return getHome("home", model);
	}

	@RequestMapping(value = "/{page}", method = RequestMethod.GET)
	public String getHome(@PathVariable(value = "page") String requestPage, ModelMap model) {
		Page page = pages.findByName(requestPage);
		return page.getTemplate();
	}

}
