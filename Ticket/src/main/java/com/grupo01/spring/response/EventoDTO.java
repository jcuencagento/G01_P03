package com.grupo01.spring.response;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grupo01.spring.model.TicketEvent;

@Data
public class EventoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(EventoDTO.class);

	private int event_id;
	private String nombre;
	
	public static EventoDTO of(TicketEvent evento) {
		log.info("--------ADAPTER EVENT CON EVENTO ------"+evento.getNombre());
		EventoDTO e = new EventoDTO();
		e.setEvent_id(evento.getEvent_id());
		e.setNombre(evento.getNombre());
		log.info("-------HE SALIDO DEL ADAPTER EVENTS-------");
		return e;
	}
	
	public static List<EventoDTO> of(List<TicketEvent> eventos) {
		log.info("----- ADAPTER LIST EVENT CON :" + eventos);
		return eventos.
				stream()
				.map(e -> of(e))
				.collect(Collectors.toList());
	}

}
