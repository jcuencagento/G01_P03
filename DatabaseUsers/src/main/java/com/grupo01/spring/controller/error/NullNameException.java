package com.grupo01.spring.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class NullNameException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	public NullNameException() {
		super("Name Must not be null. Please fill field Name and try again");
	}
	
}
