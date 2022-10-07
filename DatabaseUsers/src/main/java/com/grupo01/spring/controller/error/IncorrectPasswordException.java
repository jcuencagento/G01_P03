package com.grupo01.spring.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class IncorrectPasswordException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IncorrectPasswordException() {
		super("Incorrect password. FAIL!");
	}
}
