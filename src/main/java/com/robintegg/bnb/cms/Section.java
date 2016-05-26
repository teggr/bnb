package com.robintegg.bnb.cms;

import java.util.ArrayList;
import java.util.List;

public class Section {

	public static class Builder {

		private List<Article> articles = new ArrayList<>();
		private String sectionTitle;

		public Builder(String sectionTitle) {
			this.sectionTitle = sectionTitle;
		}

		public Section build() {
			return new Section(this);
		}

		public Builder article(Article article) {
			articles.add(article);
			return this;
		}

	}

	private String title;
	private List<Article> articles;

	public Section(Builder builder) {
		this.title = builder.sectionTitle;
		this.articles = builder.articles;
	}

	public String getTitle() {
		return title;
	}

	public List<Article> getArticles() {
		return articles;
	}

}
