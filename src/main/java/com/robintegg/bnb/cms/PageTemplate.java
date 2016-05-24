package com.robintegg.bnb.cms;

public class PageTemplate {

	private String template;
	private ContentTemplate contentTemplate;

	public PageTemplate(String template, ContentTemplate contentTemplate) {

		assert template != null;
		assert contentTemplate != null;

		this.template = template;
		this.contentTemplate = contentTemplate;

	}

	public String getTemplate() {
		return template;
	}

	public ContentTemplate getContentTemplate() {
		return contentTemplate;
	}

}
