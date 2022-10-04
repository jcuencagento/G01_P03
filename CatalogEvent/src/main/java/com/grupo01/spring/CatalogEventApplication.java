package com.grupo01.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CatalogEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogEventApplication.class, args);
	}

}
