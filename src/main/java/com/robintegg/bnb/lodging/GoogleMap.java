package com.robintegg.bnb.lodging;

import java.net.URI;

public class GoogleMap {

	public static GoogleMap newInstance(String mapUrl, String imageUrl) {
		URI.create(mapUrl);
		GoogleMap googleMap = new GoogleMap();
		googleMap.url = mapUrl;
		googleMap.image = imageUrl;
		return googleMap;
	}

	GoogleMap() {
	}

	private String url;
	private String image;

	@Override
	public String toString() {
		return "GoogleMap [url=" + url + ", image=" + image + "]";
	}

}
