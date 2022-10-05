package com.grupo01.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo01.spring.controller.error.EventFoundException;
import com.grupo01.spring.controller.error.EventNotFoundException;
import com.grupo01.spring.model.Evento;
import com.grupo01.spring.model.response.EventoDTO;
import com.grupo01.spring.repository.EventRepo;
import com.grupo01.spring.service.EventService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/evento")
@Tag(name = "evento", description = "el evento API")
public class EventController {
	
	private static final Logger log = LoggerFactory.getLogger(EventController.class);
	
	@Autowired
	EventService service;
	@Autowired
	EventRepo eventRepo;

	
	@GetMapping("")
	public List<EventoDTO> eventoListado() {
		log.info("----Listado en EventController----");
		final List<Evento> all = service.eventoListado();
		return EventoDTO.of(all);
	}
	

	@Operation(summary = "Buscar evento por ID", description = "Dado un ID, devuelve un objeto Event", tags= {"evento"})
	//No se por que no funciona esta parte:
	/*
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Evento localizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Evento.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido", content = @Content),
			@ApiResponse(responseCode = "404", description = "Evento no encontrado (NO implementado)", content = @Content) })
	*/
	@GetMapping("/{event_id}")
	public EventoDTO eventoByEvent_id(@PathVariable int event_id) {
		log.info("----Listado por id de evento en EventController----");
		return EventoDTO.of(service.eventoByEvent_id(event_id).orElseThrow(EventNotFoundException::new)); //Crear excepcion evento NO encontrado
	}
	
	
	@PostMapping("/add")
	public EventoDTO addEvento(@RequestBody Evento evento) throws Exception { //Crear excepcion evento encontrado
		log.info("----Add Evento en EventController----");
		for(Evento e: eventRepo.findAll()) {
			evento.setEvent_id(e.getEvent_id());
			if(e.equals(evento)) throw new EventFoundException();
		}
		evento.setEvent_id(eventRepo.findAll().size());
		return EventoDTO.of(service.addEvento(evento));
	}

}
