package com.grupo01.spring.controller.error;

public class EventNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EventNotFoundException() {
		super("Event NOT found. FAIL!!");
	}
	
	public EventNotFoundException(int id) {
		super("Event:"+id+" NOT found. FAIL!!");
	}
}
