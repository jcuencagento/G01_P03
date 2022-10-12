package com.grupo01.spring.controller;

import java.util.List;

import javax.ws.rs.HeaderParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.grupo01.spring.controller.error.TicketNotFoundException;
import com.grupo01.spring.model.Ticket;
import com.grupo01.spring.response.TicketDTO;
import com.grupo01.spring.service.TicketService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	private static Logger log = LoggerFactory.getLogger(TicketController.class);

	@Autowired
	private TicketService ticketService;


	@Operation(summary = "Listar tickets", description = "Lista de tickets", tags= {"Ticket"})
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Lista de tickets encontrada.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Ticket.class)) }),
			  @ApiResponse(responseCode = "404", description = "Lista no encontrada", 
			    content = @Content)})
	@GetMapping("")
	public List<TicketDTO> listTicket() {
		log.info("------------ESTOY EN LIST TICKET CONTROLLER------");
		return TicketDTO.of(ticketService.listTicket());
	}
	

	@Operation(summary = "Ticket por id", description = "Introducir un id para ver sus datos", tags= {"Ticket"})
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Ticket encontrado.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Ticket.class)) }),
			  @ApiResponse(responseCode = "404", description = "Ticket no encontrado", 
			    content = @Content)})
	@GetMapping("/{ticket_id}")
	public TicketDTO findByTicketId(@PathVariable int ticket_id) {
		log.info("------------ESTOY EN FIND TICKET CONTROLLER------BUSCANDO EL: "+ticket_id);
		return TicketDTO.of(ticketService.findByTicketId(ticket_id).orElseThrow(TicketNotFoundException::new));
	}
	
	
	@Operation(summary = "Crear ticket para comprar", description = "Necesitas logearte con mail y pwd", tags= {"Ticket"})
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "202", description = "Usuario aceptado ticket creado."),
			  @ApiResponse(responseCode = "401", description = "Password incorrecta", content = @Content),
			  @ApiResponse(responseCode = "403", description = "No permtido", content = @Content),
			  @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = @Content)
			  })
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@PostMapping("/buy")
	public void addTicket(@RequestParam String mail, @RequestParam String pwd) throws Exception {
		log.info("------------ESTOY EN BUY (ADD A TICKET) CONTROLLER------");
		ticketService.addTicket(mail, pwd);
	}
	

	@Operation(summary = "Meter evento al ticket", description = "Eliges el ticket y el evento que introduciras", tags= {"Ticket"})
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Evento al ticket."),
			  @ApiResponse(responseCode = "404", description = "Ticket no encontrado", content = @Content)
			  })
	@PostMapping("{ticket_id}/add")
	public void addEvent(@PathVariable int ticket_id, @RequestParam int event_id) {
		log.info("------------ESTOY EN ADD EVENT POR CANT A TICKET CONTROLLER------");
		this.addEvent(ticket_id, event_id);
	}
	
	@Operation(summary = "Finalizar la compra del ticket en la pasarela", description = "Eliges el ticket", tags= {"Ticket"})
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Pasarela de pago."),
			  @ApiResponse(responseCode = "404", description = "Ticket no encontrado", content = @Content)
			  })
	@GetMapping("{ticket_id}/pay")
	public String payTicket(@PathVariable int ticket_id) {
		log.info("------------ESTOY EN PAY A TICKET CONTROLLER------");
		return ticketService.pay(ticket_id);
	}
	
	public String getToken(int ticket_id) {
		return ticketService.getToken(ticket_id);
	}

}
