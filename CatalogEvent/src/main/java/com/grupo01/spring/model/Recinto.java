package com.grupo01.spring.model;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Recinto {

	private String nombre;
	private String ciudad;
	private String direccion;
	private String tipo;
	private int aforo;

}
