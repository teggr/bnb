package com.robintegg.bnb.web;

import java.util.Arrays;

import org.pegdown.Extensions;
import org.pegdown.PegDownProcessor;
import org.thymeleaf.Arguments;
import org.thymeleaf.messageresolver.AbstractMessageResolver;
import org.thymeleaf.messageresolver.MessageResolution;

import com.robintegg.bnb.cms.PageModel;

public class CmsPageModelMessageResolver extends AbstractMessageResolver {

	private PegDownProcessor pegDownProcessor = new PegDownProcessor(Extensions.NONE);

	private static final String MODEL_ATTRIBUTE_NAME = "model";

	@Override
	public MessageResolution resolveMessage(Arguments arguments, String key, Object[] messageParameters) {

		Object object = arguments.getContext().getVariables().get(MODEL_ATTRIBUTE_NAME);
		if (object instanceof PageModel) {
			if (((PageModel) object).containsKey(key)) {
				String valueOf = ((PageModel) object).valueOf(key);
				if (Arrays.asList(messageParameters).contains("markdown")) {
					if (valueOf != null) {
						valueOf = pegDownProcessor.markdownToHtml(valueOf);
					}
				}
				return new MessageResolution(valueOf);
			}
		}

		return null;
	}

}
