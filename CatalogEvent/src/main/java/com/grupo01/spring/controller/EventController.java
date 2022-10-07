package com.grupo01.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo01.spring.controller.error.EventFoundException;
import com.grupo01.spring.controller.error.EventNotFoundException;
import com.grupo01.spring.controller.error.EventNullException;
import com.grupo01.spring.controller.error.ListaVaciaException;
import com.grupo01.spring.model.Evento;
import com.grupo01.spring.model.response.EventoDTO;
import com.grupo01.spring.repository.EventRepo;
import com.grupo01.spring.service.EventService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/evento")
@Tag(name="evento", description="El evento API")
public class EventController {
	
	private static final Logger log = LoggerFactory.getLogger(EventController.class);
	
	@Autowired
	EventService service;
	@Autowired
	EventRepo eventRepo;
	
	
	@Operation(summary = "Buscar eventos", description = "Devuelve todos los objetos Event", tags= {"evento"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Eventos mostrados", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Evento.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido", content = @Content),
			@ApiResponse(responseCode = "404", description = "Not Found", content = @Content) })
	@ExceptionHandler(ListaVaciaException.class)
	@GetMapping("")
	public List<EventoDTO> eventoListado() {
		log.info("----Listado en EventController----");
		final List<Evento> all = service.eventoListado();
		if (all == null) throw new ListaVaciaException();
		return EventoDTO.of(all);
	}
	
	
	@Operation(summary = "Buscar evento por ID", description = "Dado un ID, devuelve un objeto Event", tags= {"evento"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Evento localizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Evento.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido", content = @Content),
			@ApiResponse(responseCode = "404", description = "Evento no encontrado", content = @Content) })
	@GetMapping("/{event_id}")
	public EventoDTO eventoByEvent_id(@PathVariable int event_id) {
		log.info("----Listado por id de evento en EventController----");
		return EventoDTO.of(service.eventoByEvent_id(event_id).orElseThrow(EventNotFoundException::new)); 
	}
	
	
	@Operation(summary = "Dar de alta un evento", description = "Agrega y devuelve un objeto Event", tags= {"evento"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Dado de alta", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Evento.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido", content = @Content) })
	@PostMapping("/add")
	public EventoDTO addEvento(@RequestBody Evento evento) throws Exception {
		log.info("----Add Evento en EventController----");
		if(evento.getNombre()==null) throw new EventNullException();
		int last_id = 0;
		for(Evento e: eventRepo.findAll()) {
			last_id = e.getEvent_id();
			evento.setEvent_id(last_id);
			if(e.equals(evento)) throw new EventFoundException();
		}
		last_id = last_id+1;
		evento.setEvent_id(last_id);
		return EventoDTO.of(service.addEvento(evento));
	}
	
	
	@Operation(summary = "Eliminar un evento por id", description = "ELIMINA un objeto Event", tags= {"evento"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Eliminado correctamente"),
			@ApiResponse(responseCode = "400", description = "No válido", content = @Content),
			@ApiResponse(responseCode = "404", description = "Evento no encontrado", content = @Content) })
	@DeleteMapping("/delete/{event_id}")
	public void deleteEvento(@PathVariable int event_id) {
		log.info("----Delete Evento en EventController----");
		Evento e = service.eventoByEvent_id(event_id).orElseThrow(EventNotFoundException::new);
		service.deleteEvento(e.getEvent_id());
	}
	
	
	@Operation(summary = "Buscar evento por nombre", description = "Dado un nombre, devuelve un listado de objetos Event", tags= {"evento"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Evento/s localizado/s", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Evento.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido", content = @Content),
			@ApiResponse(responseCode = "404", description = "Evento no encontrado", content = @Content) })
	@GetMapping("/nombre/{nombre}")
	public List<EventoDTO> eventoByNombre(@PathVariable String nombre) {
		log.info("----Evento por nombre en EventController----");
		List<Evento> events = service.eventoByNombre(nombre);
		if (events == null) throw new ListaVaciaException();
		return EventoDTO.of(events);
	}
	
	
	@Operation(summary = "Buscar evento por genero", description = "Dado un genero, devuelve un listado de objetos Event", tags= {"evento"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Evento/s localizado/s", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Evento.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido", content = @Content),
			@ApiResponse(responseCode = "404", description = "Evento no encontrado", content = @Content) })
	@GetMapping("/genero/{genero}")
	public List<EventoDTO> eventoByGenero(@PathVariable String genero) {
		log.info("----Evento por genero en EventController----");
		List<Evento> events = service.eventoByGenero(genero);
		if (events == null) throw new ListaVaciaException();
		return EventoDTO.of(events);
	}
	
	
	@Operation(summary = "Editar evento introduciendo id", description = "Dado un id y un Evento, actualiza y devuelve el objeto Event", tags= {"evento"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Evento editado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Evento.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido", content = @Content),
			@ApiResponse(responseCode = "404", description = "Evento no encontrado", content = @Content) })
	@PutMapping("/{event_id}/edit")
	public EventoDTO editEvento(@RequestBody Evento editado) {
		log.info("----Add Evento en EventController----");
		for(Evento actual: eventRepo.findAll()) {
			if(actual.getEvent_id() == editado.getEvent_id()) return EventoDTO.of(service.editEvento(actual, editado));
		}
		throw new EventNotFoundException();
	}

}
