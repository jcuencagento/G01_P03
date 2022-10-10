package com.grupo01.spring.payment;

import com.grupo01.spring.model.PaymentStatus;
import com.grupo01.spring.request.PaymentRequest;

public interface Pasarela {
  PaymentStatus pago(PaymentRequest request);
}
