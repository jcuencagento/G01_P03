package com.grupo01.spring.controller.error;

public class EventNullException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EventNullException() {
		super("Evento con nombre nulo. FAIL!");
	}
}
