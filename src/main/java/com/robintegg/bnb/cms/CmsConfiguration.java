package com.robintegg.bnb.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;

@Configuration
public class CmsConfiguration {

	@Autowired
	public void addCustomThymeleafMessageResolvers(TemplateEngine engine) {
		engine.addMessageResolver(new CmsPageModelMessageResolver());
	}

}
