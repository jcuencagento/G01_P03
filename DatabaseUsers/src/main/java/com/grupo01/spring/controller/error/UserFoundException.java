package com.grupo01.spring.controller.error;

public class UserFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserFoundException() {
		super("User found given its e-mail! Cannot create User.");
	}


}
