package com.doctor.dosage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DosageApplication {

	public static void main(String[] args) {
		SpringApplication.run(DosageApplication.class, args);
	}
}
