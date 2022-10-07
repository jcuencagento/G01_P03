package com.grupo01.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupo01.spring.response.TicketDTO;
import com.grupo01.spring.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	private static Logger log = LoggerFactory.getLogger(TicketController.class);

	@Autowired
	private TicketService ticketService;


	@GetMapping("")
	public List<TicketDTO> listTicket() {
		log.info("------------ESTOY EN LIST TICKET CONTROLLER------");
		return TicketDTO.of(ticketService.listTicket());
	}

	@GetMapping("/{ticket_id}")
	public TicketDTO findByTicketId(@PathVariable int id) {
		return TicketDTO.of(ticketService.findByTicketId(id).orElseThrow());
	}
	
	//@PostMapping("/add")
	

	@PostMapping("{ticket_id}/add")
	public void addEvent(@PathVariable int ticket_id, @RequestParam int event_id,
			@RequestParam(defaultValue = "1") int cant) {
		log.info("------------ESTOY EN ADD EVENT A TICKET CONTROLLER------");
		ticketService.addEvent(ticket_id, event_id, cant);
	}

}