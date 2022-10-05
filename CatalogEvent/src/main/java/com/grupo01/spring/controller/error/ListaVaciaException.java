package com.grupo01.spring.controller.error;

public class ListaVaciaException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ListaVaciaException() {
		super("Lista Vacia.");
	}

}
