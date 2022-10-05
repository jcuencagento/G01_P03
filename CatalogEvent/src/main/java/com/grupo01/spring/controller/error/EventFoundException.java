package com.grupo01.spring.controller.error;

public class EventFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EventFoundException() {
		super("Event found and NOT expected. FAIL!!");
	}
	
	public EventFoundException(int id) {
		super("Event:"+id+" found and NOT expected. FAIL!!");
	}

}
