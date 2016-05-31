package com.robintegg.bnb.cms;

import org.thymeleaf.Arguments;
import org.thymeleaf.messageresolver.AbstractMessageResolver;
import org.thymeleaf.messageresolver.MessageResolution;

public class CmsPageModelMessageResolver extends AbstractMessageResolver {

	private static final String MODEL_ATTRIBUTE_NAME = "model";

	@Override
	public MessageResolution resolveMessage(Arguments arguments, String key, Object[] messageParameters) {

		Object object = arguments.getContext().getVariables().get(MODEL_ATTRIBUTE_NAME);
		if (object instanceof PageModel) {
			return new MessageResolution(((PageModel) object).valueOf(key));
		}

		return null;
	}

}
