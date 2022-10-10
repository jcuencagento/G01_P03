package com.grupo01.spring.dto;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grupo01.spring.model.TicketEvent;

import lombok.Data;

@Data
public class EventoDTO {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(EventoDTO.class);

	private int event_id;
	private String nombre;
	private String descLarga;
	private String genero;
	private String rangoPrecios;
	// private String ciudad;
	private int precio;

	public static EventoDTO of(TicketEvent evento) {
		log.info("--------ADAPTER EVENT CON EVENTO ------" + evento.getNombre());
		EventoDTO e = new EventoDTO();
		e.setEvent_id(evento.getEvent_id());
		e.setNombre(evento.getNombre());
		e.setDescLarga(evento.getDescLarga());
		e.setGenero(evento.getGenero());
		e.setRangoPrecios(evento.getRangoPrecios());
		e.setPrecio(evento.getPrecio());
		log.info("-------HE SALIDO DEL ADAPTER EVENTS-------");
		return e;
	}

	public static List<EventoDTO> of(List<TicketEvent> eventos) {
		log.info("----- ADAPTER LIST EVENT CON :" + eventos);
		return eventos.stream().map(e -> of(e)).collect(Collectors.toList());
	}

}
