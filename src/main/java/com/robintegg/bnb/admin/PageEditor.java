package com.robintegg.bnb.admin;

import com.robintegg.bnb.cms.Page;
import com.robintegg.bnb.cms.PageTemplate;

public class PageEditor {

	private Page page;
	private PageTemplate pageTemplate;

	public PageEditor(Page page, PageTemplate pageTemplate) {
		this.page = page;
		this.pageTemplate = pageTemplate;
	}
	
	public Page getPage() {
		return page;
	}
	
	public PageTemplate getPageTemplate() {
		return pageTemplate;
	}

}
