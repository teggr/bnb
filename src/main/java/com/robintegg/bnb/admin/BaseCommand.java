package com.robintegg.bnb.admin;

import org.springframework.validation.Validator;

import com.robintegg.bnb.core.Command;

public class BaseCommand {

	protected Validator validator;

	public BaseCommand(Validator validator) {
		super();
		this.validator = validator;
	}

}