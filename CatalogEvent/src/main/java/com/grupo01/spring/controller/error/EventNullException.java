package com.grupo01.spring.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class EventNullException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EventNullException() {
		super("Evento con nombre nulo. FAIL!");
	}
}
