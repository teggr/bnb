package com.robintegg.bnb.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Account {

	private AccountRepository accountRepository;

	@Autowired
	public Account(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public AccountSettings getSettings() {
		return accountRepository.findAll().stream().findFirst().orElse(new AccountSettings());
	}

	public void setSettings(AccountSettings settings) {
		accountRepository.save(settings);
	}

}
