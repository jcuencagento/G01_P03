package com.grupo01.spring.model;

public enum PaymentStatus {
	OK("200", "Pago aceptado!"),
	ERROR_TRANSACCION("400.001", "Error en la transaccion"),
	ERROR_SALDO("116.001", "Usted no tiene un euro");
	

	private String codigo;
	private String descripcion;

	private PaymentStatus(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Codigo: " + codigo + ". Descripcion: " + descripcion;
	}
}
