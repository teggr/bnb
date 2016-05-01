package com.robintegg.bnb.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.robintegg.bnb.core.Command;
import com.robintegg.bnb.core.EmailAddress;

public class AccountUpdateCommand extends BaseCommand implements Command {

	private static final Logger log = LoggerFactory.getLogger(AccountUpdateCommand.class);
	private AccountUpdate update;
	private BindingResult result;
	private AccountRepository repository;

	public AccountUpdateCommand(AccountUpdate update, BindingResult result, Validator validator,
			AccountRepository repository) {
		super(validator);
		this.update = update;
		this.result = result;
		this.repository = repository;
	}

	@Override
	public void audit() {
		log.info("Updating account {}", update);
	}

	@Override
	public void execute() {

		if (result.hasErrors()) {
			return;
		}

		Account account = Account.getInstance(repository);

		updateAccount(account);

		// validate the domain object before making the update?
		validator.validate(account, result);

		if (!result.hasErrors()) {
			repository.save(account);
		}

	}

	private void updateAccount(Account account) {

		account.emailAddress = EmailAddress.newInstance(update.getEmailAddress());

	}

}
