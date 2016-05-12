package com.robintegg.bnb.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.robintegg.bnb.admin.Account;
import com.robintegg.bnb.admin.AccountSettings;

@Controller
public class HomeController {

	private Account account;

	@Autowired
	public HomeController(Account account) {
		this.account = account;
	}

	@ModelAttribute("settings")
	public AccountSettings getSettings() {
		return account.getSettings();
	}

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String getHome() {
		return "home";
	}

}
