package com.grupo01.spring.controller.error;

public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException() {
		super("User NOT found. FAIL!!");
	}

}
