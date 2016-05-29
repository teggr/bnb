package com.robintegg.bnb.cms;

import com.robintegg.bnb.core.Title;
import com.robintegg.bnb.db.BaseEntity;

public class Page extends BaseEntity {

	public static class Builder {

		private static long idGen = 1;
		private Long id;
		private String template;
		private boolean home = false;
		private Title title;

		public Builder(String template, Title title) {
			this.title = title;
			this.id = idGen++;
			this.template = template;
		}

		public Builder makeHome() {
			this.home = true;
			return this;
		}

		public Page build() {
			return new Page(this);
		}

	}

	private String template;
	private boolean home;
	private Title title;
	private PageModel model = new PageModel();

	public Page(Builder builder) {
		this.title = builder.title;
		this.template = builder.template;
		this.home = builder.home;
		setId(builder.id);
	}

	public boolean isHome() {
		return home;
	}

	public String getTemplate() {
		return template;
	}

	public Title getTitle() {
		return title;
	}

	public String valueOf(String fieldName) {
		return model.getValue(fieldName);
	}

}
