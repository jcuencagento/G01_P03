package com.grupo01.spring.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserFoundException() {
		super("User found given its e-mail! Cannot create User.");
	}


}
