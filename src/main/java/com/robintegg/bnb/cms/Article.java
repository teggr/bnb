package com.robintegg.bnb.cms;

import java.util.ArrayList;
import java.util.List;

public class Article {

	public static class Builder {

		private List<Field> fields = new ArrayList<>();

		public Builder field(Field field) {
			fields.add(field);
			return this;
		}

		public Article build() {
			return new Article(this);
		}

	}

	private List<Field> fields;

	private Article(Builder builder) {
		this.fields = builder.fields;
	}

	public List<Field> getFields() {
		return fields;
	}
}
