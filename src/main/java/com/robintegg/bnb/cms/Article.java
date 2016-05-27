package com.robintegg.bnb.cms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Article extends AbstractContentNode {

	public static class Builder {

		private List<Field> fields = new ArrayList<>();
		private String articleName;

		public Builder(String articleName) {
			this.articleName = articleName;
		}

		public Builder field(Field field) {
			fields.add(field);
			return this;
		}

		public Article build() {
			return new Article(this);
		}

	}

	private List<Field> fields = new ArrayList<>();

	private Article(Builder builder) {
		super(builder.articleName);
		for (Field field : builder.fields) {
			addField(field);
		}
	}

	public void addField(Field field) {
		fields.add(field);
		field.setParent(this);
	}

	public Collection<Field> getFields() {
		return fields;
	}

}
