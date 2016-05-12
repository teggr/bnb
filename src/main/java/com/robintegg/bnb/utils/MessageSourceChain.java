package com.robintegg.bnb.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;

public class MessageSourceChain implements MessageSource {

	private List<MessageSource> sources;

	public MessageSourceChain(MessageSource... sources) {
		this.sources = Arrays.asList(sources);
	}

	public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
		for (MessageSource messageSource : sources) {
			String message = messageSource.getMessage(code, args, defaultMessage, locale);
			if (!StringUtils.equalsIgnoreCase(message, defaultMessage)) {
				return message;
			}
		}
		return defaultMessage;
	}

	public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
		for (MessageSource messageSource : sources) {
			try {
				return messageSource.getMessage(code, args, locale);
			} catch (NoSuchMessageException e) {
				// move onto the next
			}
		}
		throw new NoSuchMessageException(code, locale);
	}

	public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
		for (MessageSource messageSource : sources) {
			try {
				return messageSource.getMessage(resolvable, locale);
			} catch (NoSuchMessageException e) {
				// move onto the next
			}
		}
		throw new NoSuchMessageException("", locale);
	}

}
