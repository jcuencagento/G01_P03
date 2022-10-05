package com.grupo01.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.grupo01.spring.controller.EventController;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration
public class OpenApiConfig {
	
	private static final Logger log = LoggerFactory.getLogger(EventController.class);
	
	
    @Bean
    public OpenAPI EventOpenAPI() {
    	log.info("------OpenApiConfig-------");
        return new OpenAPI()
                .info(new Info().title("Evento API")
                .description("Documentación de los Eventos. API")
                .version("v1.0")
                .contact(new Contact().name("Grupo 01").
                        url("https://antoniosantos.es").email("antonio@santos.es"))
                .license(new License().name("LICENSE").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                .description("Proyecto 3. LucaTicket")
                .url("https://miproyecto.es"));
    }
	
}