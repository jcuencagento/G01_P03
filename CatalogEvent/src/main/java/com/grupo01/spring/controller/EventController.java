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

import com.grupo01.spring.model.Evento;
import com.grupo01.spring.model.response.EventoDTO;
import com.grupo01.spring.service.EventService;

@RestController
@RequestMapping("/evento")
public class EventController {
	
	private static final Logger log = LoggerFactory.getLogger(EventController.class);
	
	@Autowired
	EventService service;

	
	@GetMapping("")
	public List<EventoDTO> eventoListado() {
		log.info("----Listado en EventController----");
		final List<Evento> all = service.eventoListado();
		return EventoDTO.of(all);
	}
	
	@GetMapping("/{event_id}")
	public EventoDTO eventoByEvent_id(@PathVariable int event_id) {
		log.info("----Listado por id de evento en EventController----");
		return EventoDTO.of(service.eventoByEvent_id(event_id).orElseThrow());
	}
	
	
	@PostMapping("/add")
	public EventoDTO addEvento(@RequestBody Evento evento) {
		log.info("----Add Evento en EventController----");
		
		return EventoDTO.of(service.addEvento(evento));
	}

}
