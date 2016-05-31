package com.robintegg.bnb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.robintegg.bnb.core.Address;
import com.robintegg.bnb.core.EmailAddress;
import com.robintegg.bnb.core.PhoneNumber;
import com.robintegg.bnb.lodging.GoogleMap;
import com.robintegg.bnb.lodging.Lodging;
import com.robintegg.bnb.lodging.LodgingName;

@SpringBootApplication
public class Bnb2Application {

	public static void main(String[] args) {
		SpringApplication.run(Bnb2Application.class, args);
	}

	@Bean
	public Lodging lodging() {
		return Lodging.newInstance(LodgingName.newInstance("Pension Moosholz"),
				Address.newInstance("Pension Moosholz", "Moosholzweg 4", "D-38678", "Deutschland", ""),
				PhoneNumber.newInstance("01234 555555"), PhoneNumber.newInstance("01234 666666"),
				EmailAddress.newInstance("pension-moosholz@mail.de"),
				GoogleMap.newInstance(
						"https://www.google.co.uk/maps/place/Moosholzweg+4,+38678+Clausthal-Zellerfeld,+Germany/@51.7765777,10.3320373,15z/data=!4m7!1m4!3m3!1s0x47a53b794f1a9479:0x440af30bbcb240e9!2sMoosholzweg+4,+38678+Clausthal-Zellerfeld,+Germany!3b1!3m1!1s0x47a53b794f1a9479:0x440af30bbcb240e9",
						""));
	}

}
