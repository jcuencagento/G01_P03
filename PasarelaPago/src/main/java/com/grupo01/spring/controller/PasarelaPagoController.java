package com.grupo01.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo01.spring.dto.PagoDTO;
import com.grupo01.spring.request.PaymentRequest;
import com.grupo01.spring.utils.Randomizador;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/pasarelapago")
public class PasarelaPagoController {
	
	private static Logger log = LoggerFactory.getLogger(PasarelaPagoController.class);
	
	@Operation(summary = "Pago", description = "Pasarela de pago de tickets", tags= {"PagoDTO"})
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Pago resuelto.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = PagoDTO.class)) }),
			  @ApiResponse(responseCode = "404", description = "No encontrado", 
			    content = @Content)})
	@PostMapping("{ticket_id}")
	public PagoDTO pago(@PathVariable int ticket_id, @RequestParam int precio_total, @RequestParam String user_mail){
		log.info("----PASARELA DE PAGO-------");
		PagoDTO result = new PagoDTO(ticket_id, user_mail, precio_total, PaymentRequest.getCodigo(Randomizador.generarNumAleatorio(1, 1000)).toString());
		return result;


	}
	
}
