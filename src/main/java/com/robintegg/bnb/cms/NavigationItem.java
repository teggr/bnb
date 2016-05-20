package com.robintegg.bnb.cms;

public class NavigationItem {

	private boolean active;
	private Page page;

	public NavigationItem(Page page, boolean active) {
		super();
		this.page = page;
		this.active = active;
	}

	public String getPage() {
		return page.getName();
	}

	public boolean isActive() {
		return active;
	}

}
