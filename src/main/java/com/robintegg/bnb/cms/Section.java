package com.robintegg.bnb.cms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Section extends AbstractContentNode {

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

	private List<Article> articles = new ArrayList<>();

	public Section(Builder builder) {
		super(builder.sectionTitle);
		for (Article article : builder.articles) {
			addArticle(article);
		}
	}

	private void addArticle(Article article) {
		this.articles.add(article);
		article.setParent(this);
	}

	public String getTitle() {
		return getName();
	}

	public Collection<Article> getArticles() {
		return articles;
	}

}
