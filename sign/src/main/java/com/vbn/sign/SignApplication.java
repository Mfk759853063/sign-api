package com.vbn.sign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class SignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SignApplication.class, args);
		log.info("info");
		log.error("error");
	}

}
