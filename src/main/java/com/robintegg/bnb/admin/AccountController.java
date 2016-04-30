package com.robintegg.bnb.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/account")
public class AccountController {

	@RequestMapping(method = RequestMethod.GET)
	public String getAccount(ModelMap map) {
		return "/admin/account";
	}

}
