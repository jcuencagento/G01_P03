package com.grupo01.spring.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class NullMailException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NullMailException() {
		super("Field mail is empty. Fill in the information and try again.");
	}
	
}
