package com.grupo01.spring.model;

public enum PaymentStatus {
	OK(200, "Pago aceptado!"), ERROR(400, "Error en la transaccion"), ERROR_SALDO(116, "Usted no tiene un euro");

	private int codigo;
	private String descripcion;

	private PaymentStatus(int codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Codigo: " + codigo + ". Descripcion: " + descripcion;
	}
}
