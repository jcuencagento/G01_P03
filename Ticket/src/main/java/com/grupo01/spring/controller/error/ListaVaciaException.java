package com.grupo01.spring.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ListaVaciaException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ListaVaciaException() {
		super("Lista Vacia.");
	}

}
