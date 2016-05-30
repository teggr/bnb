package com.robintegg.bnb.admin;

import com.robintegg.bnb.cms.Page;
import com.robintegg.bnb.cms.PageModel;
import com.robintegg.bnb.cms.PageTemplate;

public class PageEditor {

	private PageModel page;
	private PageTemplate pageTemplate;

	public PageEditor(PageModel page, PageTemplate pageTemplate) {
		this.page = page;
		this.pageTemplate = pageTemplate;
	}
	
	public PageModel getPage() {
		return page;
	}
	
	public PageTemplate getPageTemplate() {
		return pageTemplate;
	}

}
