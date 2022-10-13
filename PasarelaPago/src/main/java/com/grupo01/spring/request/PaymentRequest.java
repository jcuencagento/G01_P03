package com.grupo01.spring.request;

import com.grupo01.spring.model.PaymentStatus;

public class PaymentRequest {

	public static PaymentStatus getCodigo(int random) {
		
		if (random < 800)
			return PaymentStatus.OK;
		if (random < 900)
			return PaymentStatus.ERROR_BANK;
		if (random < 910)
			return PaymentStatus.ERROR_ACCOUNTNUMBER;
		if (random < 920)
			return PaymentStatus.ERROR_EXPIRYMONTH;
		if (random < 930)
			return PaymentStatus.ERROR_CARDSECURITYCODE;
		if (random < 940)
			return PaymentStatus.ERROR_CURRENCY;
		if (random < 950)
			return PaymentStatus.ERROR_NOCARD;
		if (random < 960)
			return PaymentStatus.ERROR_DECLINED;
		if (random < 970)
			return PaymentStatus.ERROR_DEBITNOTAPROVED;
		if (random < 980)
			return PaymentStatus.ERROR_COUNTRYNOTSUPPORTED;
		if (random < 990)
			return PaymentStatus.ERROR_EXPIREDCARD;

		return PaymentStatus.ERROR_ACCOUNTBLOCKED;
	}
}
