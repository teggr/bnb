package com.robintegg.bnb.lodging;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LodgingRepository {

	private Lodging lodging;

	@Autowired
	public LodgingRepository( Lodging lodging ) {
		this.lodging = lodging;
	}

	public List<Lodging> findAll() {
		return Arrays.asList(lodging);
	}

	public void save(Lodging lodging) {
		this.lodging = lodging;
	}

}
