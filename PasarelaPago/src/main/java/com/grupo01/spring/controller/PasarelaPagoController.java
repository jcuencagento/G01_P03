package com.grupo01.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo01.spring.dto.PagoDTO;
import com.grupo01.spring.request.PaymentRequest;
import com.grupo01.spring.utils.Randomizador;

@RestController
@RequestMapping("/pasarelapago")
public class PasarelaPagoController {

	@Autowired
	private PaymentRequest request;
	
	@PostMapping("{ticket_id}")
	public PagoDTO pago(@PathVariable int ticket_id, @RequestParam int precio_total, @RequestParam String user_mail){
		PagoDTO result = new PagoDTO(ticket_id, user_mail, precio_total, request.getCodigo(Randomizador.generarNumAleatorio(1, 1000)));
		return result;


	}
	
}
