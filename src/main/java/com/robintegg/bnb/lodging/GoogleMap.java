package com.robintegg.bnb.lodging;

import java.net.URI;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
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

	@Column(length=1000)
	private String url;
	private String image;
	
	public String getImage() {
		return image;
	}
	
	public String getUrl() {
		return url;
	}

	@Override
	public String toString() {
		return "GoogleMap [url=" + url + ", image=" + image + "]";
	}

}
