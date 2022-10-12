package com.grupo01.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Recinto {

	private String nombre;
	private String ciudad;
	private String direccion;
	private String tipo;
	private int aforo;

}