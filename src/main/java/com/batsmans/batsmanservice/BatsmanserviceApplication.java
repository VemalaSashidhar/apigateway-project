package com.batsmans.batsmanservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BatsmanserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatsmanserviceApplication.class, args);
	}

}
