package com.robintegg.bnb.web;

import org.thymeleaf.Arguments;
import org.thymeleaf.messageresolver.AbstractMessageResolver;
import org.thymeleaf.messageresolver.MessageResolution;

import com.robintegg.bnb.cms.PageModel;

public class CmsPageModelMessageResolver extends AbstractMessageResolver {

	private static final String MODEL_ATTRIBUTE_NAME = "model";

	@Override
	public MessageResolution resolveMessage(Arguments arguments, String key, Object[] messageParameters) {

		Object object = arguments.getContext().getVariables().get(MODEL_ATTRIBUTE_NAME);
		if (object instanceof PageModel) {
			if (((PageModel) object).containsKey(key)) {
				return new MessageResolution(((PageModel) object).valueOf(key));
			}
		}

		return null;
	}

}
