package com.robintegg.bnb.utils;

import javax.servlet.http.HttpServletRequest;

public class UrlResolver {

	private HttpServletRequest request;

	public UrlResolver(HttpServletRequest request) {
		this.request = request;
	}
	
	public String resolve( String path ) {
		return path;
	}

}
