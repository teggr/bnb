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

import com.robintegg.bnb.core.CommandExecutorService;

@Controller
@RequestMapping("/admin/account")
public class AccountController {

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	private AccountRepository repository;

	private CommandExecutorService commandExecutorService;

	private Validator validator;

	@Autowired
	public AccountController(AccountRepository repository, CommandExecutorService commandExecutorService,
			Validator validator) {
		this.repository = repository;
		this.commandExecutorService = commandExecutorService;
		this.validator = validator;
	}

	@ModelAttribute
	public Account getAccount() {
		return Account.getInstance(repository);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getAccount(ModelMap map) {
		return "/admin/account";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String updateAccount(@ModelAttribute AccountUpdate update, BindingResult result) {

		logger.info("updateAccount: {}", update);

		AccountUpdateCommand command = new AccountUpdateCommand(update, result, validator, repository);
		
		commandExecutorService.run(command);

		if (result.hasErrors()) {
			return "/admin/account";
		}

		return "redirect:/admin";

	}

}
