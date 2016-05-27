package com.robintegg.bnb.cms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ContentTemplate {

	public static class Builder {

		private List<Section> sections = new ArrayList<>();

		public ContentTemplate build() {
			return new ContentTemplate(this);
		}

		public Builder section(Section section) {
			sections.add(section);
			return this;
		}

	}

	private List<Section> sections;

	private ContentTemplate(Builder builder) {
		sections = builder.sections;
	}

	public Collection<Section> getSections() {
		return sections;
	}

}
