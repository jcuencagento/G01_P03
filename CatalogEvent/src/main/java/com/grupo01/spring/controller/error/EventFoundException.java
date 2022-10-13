package com.grupo01.spring.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EventFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EventFoundException() {
		super("Event found and NOT expected. FAIL!!");
	}
	
	public EventFoundException(int id) {
		super("Event:"+id+" found and NOT expected. FAIL!!");
	}

}
