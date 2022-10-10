package com.grupo01.spring.request;

import com.grupo01.spring.model.PaymentStatus;
import com.grupo01.spring.utils.Randomizador;


public class PaymentRequest {
	//private int amount;

	public static PaymentStatus getCodigo() {
		int random = Randomizador.generarNumAleatorio(1, 1000);
		
		if (random < 800)
			return PaymentStatus.OK;
		if (random < 900)
			return PaymentStatus.ERROR;
		
		return PaymentStatus.ERROR_SALDO;
	}
}
