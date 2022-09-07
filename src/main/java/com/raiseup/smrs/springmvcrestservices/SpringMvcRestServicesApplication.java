package com.raiseup.smrs.springmvcrestservices;

import com.raiseup.smrs.springmvcrestservices.service.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMvcRestServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcRestServicesApplication.class, args);
	}

}
