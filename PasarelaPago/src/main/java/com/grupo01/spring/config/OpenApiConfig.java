package com.grupo01.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration
public class OpenApiConfig {
	
    @Bean
    public OpenAPI StudentOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Pago API")
                .description("Documentación de la pasarela de pago API")
                .version("v1.0")
                .contact(new Contact().name("Grupo 01")
                .url("https://antoniosantos.es").email("antonio@santos.es"))
                .license(new License().name("LICENSE").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                .description("Proyecto 3")
                .url("https://miproyecto.es"));
    }
	
}
