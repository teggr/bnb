package com.robintegg.bnb.admin;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import com.robintegg.bnb.core.EmailAddress;
import com.robintegg.bnb.db.BaseEntity;

@Entity
public class Account extends BaseEntity {

	@Embedded
	EmailAddress emailAddress;

	public EmailAddress getEmailAddress() {
		return emailAddress;
	}

	public static Account getInstance(AccountRepository repository) {
		return repository.findAll().stream().findFirst().orElse(new Account());
	}

}
