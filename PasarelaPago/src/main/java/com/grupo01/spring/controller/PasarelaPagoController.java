package com.grupo01.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.grupo01.spring.request.PaymentRequest;
import com.grupo01.spring.utils.Randomizador;

@RestController
@RequestMapping("/pasarelapago")
public class PasarelaPagoController {

	@GetMapping("{ticket_id}")
	public String pago(@PathVariable int ticket_id) {
		return "Pago del Ticket: " + ticket_id + " Ha resultado en: " + PaymentRequest.getCodigo(Randomizador.generarNumAleatorio(1, 1000)).toString();
	}
	
	/*@GetMapping("{ticket_id}")
    public String pago(@PathVariable int ticket_id, @RequestParam int precio_total, @RequestParam String user_mail){
        return "Pago del Ticket: " + ticket_id + ".\nPrecio: "+ precio_total +
                "$\nUsuario: " + user_mail +
                "\nHa resultado en: " + PaymentRequest.getCodigo().toString();
    }*/
}
