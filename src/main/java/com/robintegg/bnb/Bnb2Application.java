package com.robintegg.bnb;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.robintegg.bnb.data.DataService;

@SpringBootApplication
public class Bnb2Application {

	public static void main(String[] args) {
		SpringApplication.run(Bnb2Application.class, args);
	}

	@Bean
	public ApplicationRunner loadData(DataService dataService) {
		return new ApplicationRunner() {

			@Override
			public void run(ApplicationArguments args) throws Exception {

				dataService.prePopulate();

			}

		};
	}

}
