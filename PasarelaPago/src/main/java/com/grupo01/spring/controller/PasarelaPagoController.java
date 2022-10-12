package com.grupo01.spring.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo01.spring.request.PaymentRequest;

@RestController
@RequestMapping("/pasarelapago")
public class PasarelaPagoController {

	@PostMapping("{ticket_id}")
	public String pago(@PathVariable int ticket_id, @RequestParam int precio_total, @RequestParam String user_mail){
		return "Pago del Ticket: " + ticket_id + ".\nPrecio: "+ precio_total +
				"$\nUsuario: " + user_mail +
				"\nHa resultado en: " + PaymentRequest.getCodigo().toString();
	}
}
