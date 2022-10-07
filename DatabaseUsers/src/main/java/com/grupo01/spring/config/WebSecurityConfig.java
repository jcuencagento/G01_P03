package com.grupo01.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.grupo01.spring.security.JWTAuthorizationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

	/*
	 * se permiten todas las llamadas al controlador /user, 
	 * pero el resto de las llamadas requieren autenticación.
	 */
	
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.csrf().disable() 
		.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class) //se verifica el usuario
		.authorizeRequests() // da acceso al usuario segun: 
		.antMatchers(HttpMethod.POST, "/user").permitAll() //.hasAuthority("USER")
		.anyRequest().authenticated(); // el user autenticado puede hacer cualquier peticion
        return http.build();
  } 
}
