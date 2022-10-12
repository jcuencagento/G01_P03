package com.grupo01.spring.controller.error;

public class TicketNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public TicketNotFoundException() {
		super("Ticket NOT found. FAIL!!");
	}
}
