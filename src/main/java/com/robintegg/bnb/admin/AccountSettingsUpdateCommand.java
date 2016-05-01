package com.robintegg.bnb.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.robintegg.bnb.core.Address;
import com.robintegg.bnb.core.Command;
import com.robintegg.bnb.core.EmailAddress;
import com.robintegg.bnb.core.PhoneNumber;

public class AccountSettingsUpdateCommand extends BaseCommand implements Command {

	private static final Logger log = LoggerFactory.getLogger(AccountSettingsUpdateCommand.class);
	private AccountSettingsUpdate update;
	private BindingResult result;
	private Account account;

	public AccountSettingsUpdateCommand(AccountSettingsUpdate update, BindingResult result, Validator validator,
			Account account) {
		super(validator);
		this.update = update;
		this.result = result;
		this.account = account;
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

		AccountSettings settings = account.getSettings();

		updateAccountSettings(settings);

		// validate the domain object before making the update?
		validator.validate(account, result);

		if (!result.hasErrors()) {
			account.setSettings(settings);
		}

	}

	private void updateAccountSettings(AccountSettings settings) {

		settings.emailAddress = EmailAddress.newInstance(update.getEmailAddress());
		settings.telephoneNumber = PhoneNumber.newInstance(update.getTelephoneNumber());
		settings.mobileNumber = PhoneNumber.newInstance(update.getMobileNumber());
		settings.facebookLink = update.getFacebookLink();
		settings.tripAdvisorLink = update.getFacebookLink();
		settings.address = Address.newInstance(update.getAddressLine1(), update.getAddressLine2(),
				update.getAddressLine3(), update.getAddressLine4(), update.getAddressLine5());

	}

}
