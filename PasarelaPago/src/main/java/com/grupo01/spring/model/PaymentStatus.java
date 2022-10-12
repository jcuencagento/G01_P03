package com.grupo01.spring.model;

public enum PaymentStatus {
	OK("200", "Pago aceptado!"),

	//400
	ERROR_BANK("400.100", "Error: Bank code invalid."),
	ERROR_ACCOUNTNUMBER("400.101", "Error: Invalid account number."),
	ERROR_EXPIRYMONTH("400.102", "Error: Invalid account number expiry month."),
	ERROR_CARDSECURITYCODE("400.103", "Error: No card security code."),
	ERROR_CURRENCY("400.104", "Error: Invalid currency."),
	ERROR_NOCARD("400.105", "Error: Card information has not been provided."),
	//500
	ERROR_DECLINED("500.100", "Error: Card declined."),
	ERROR_DEBITNOTAPROVED("500.101", "Error: Debit not approved."),
	ERROR_COUNTRYNOTSUPPORTED("500.102", "Error: Country not supported."),
	ERROR_EXPIREDCARD("500.103", "Error: Expired card."),
	ERROR_ACCOUNTBLOCKED("500.104", "Error: Account blocked.");



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
