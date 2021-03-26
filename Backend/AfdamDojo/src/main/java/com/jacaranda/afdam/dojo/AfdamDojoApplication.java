package com.jacaranda.afdam.dojo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan
@EnableJpaRepositories
@SpringBootApplication//(scanBasePackages = {"com.jacaranda","com.jacaranda.afdam.dojo.security.repo"})
public class AfdamDojoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AfdamDojoApplication.class, args);
	}

}
