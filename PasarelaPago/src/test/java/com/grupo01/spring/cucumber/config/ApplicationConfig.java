package com.grupo01.spring.cucumber.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.grupo01.spring.controller.PasarelaPagoController;

@Configuration
public class ApplicationConfig {

	@Bean
	PasarelaPagoController pasarelaPagoController() {
		return new PasarelaPagoController();
	}
	
	
}
