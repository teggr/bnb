package com.robintegg.bnb.lodging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingleLodgingService {

	private LodgingRepository lodgingRepository;

	@Autowired
	public SingleLodgingService(LodgingRepository lodgingRepository) {
		this.lodgingRepository = lodgingRepository;
	}

	public Lodging getLodging() {
		return lodgingRepository.findAll().stream().findFirst().get();
	}

}
