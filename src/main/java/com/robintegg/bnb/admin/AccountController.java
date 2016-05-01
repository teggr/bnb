package com.robintegg.bnb.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.robintegg.bnb.core.CommandExecutorService;

@Controller
@RequestMapping("/admin/account")
public class AccountController {

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	private Account account;

	private CommandExecutorService commandExecutorService;

	private Validator validator;

	@Autowired
	public AccountController(Account account, CommandExecutorService commandExecutorService, Validator validator) {
		this.account = account;
		this.commandExecutorService = commandExecutorService;
		this.validator = validator;
	}

	@ModelAttribute
	public AccountSettings getAccount() {
		return account.getSettings();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getAccount(ModelMap map) {
		return "/admin/account";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String updateAccount(@ModelAttribute AccountSettingsUpdate update, BindingResult result) {

		logger.info("updateAccount: {}", update);

		AccountSettingsUpdateCommand command = new AccountSettingsUpdateCommand(update, result, validator, account);

		commandExecutorService.run(command);

		if (result.hasErrors()) {
			return "/admin/account";
		}

		return "redirect:/admin";

	}

}
