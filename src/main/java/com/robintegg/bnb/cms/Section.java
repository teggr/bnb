package com.robintegg.bnb.cms;

import java.util.ArrayList;
import java.util.List;

public class Section {

	public static class Builder {

		private List<Article> articles = new ArrayList<>();

		public Section build() {
			return new Section(this);
		}

		public Builder article(Article article) {
			articles.add(article);
			return this;
		}

		

	}

	public Section(Builder builder) {
		// TODO Auto-generated constructor stub
	}

}
