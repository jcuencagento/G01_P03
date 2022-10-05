package com.grupo01.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForceErrorRestController {
	
	@GetMapping(value="/evento/throwexc")
	public void throwException() {
		throw new IllegalArgumentException("\"I am the error message from Rest Controller\"");
	}

}
