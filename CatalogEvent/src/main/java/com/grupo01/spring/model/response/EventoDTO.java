package com.grupo01.spring.model.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.grupo01.spring.model.Evento;
import com.grupo01.spring.model.Recinto;

@Data
public class EventoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int event_id;
	private String nombre;
	private String descCorta;
	private String descLarga;
	private String fecha;
	private String hora;
	private String rangoPrecios;
	private String acceso;
	private Recinto recinto;
	
	public static EventoDTO of(Evento evento) {
		EventoDTO e = new EventoDTO();
		e.setEvent_id(evento.getEvent_id());
		e.setNombre(evento.getNombre());
		e.setDescCorta(evento.getDescCorta());
		e.setDescLarga(evento.getDescLarga());
		e.setFecha(evento.getFecha());
		e.setHora(evento.getHora());
		e.setRangoPrecios(evento.getRangoPrecios());
		e.setAcceso(evento.getAcceso());
		e.setRecinto(evento.getRecinto());
		
		return e;
	}
	
	public static List<EventoDTO> of(List<Evento> eventos){
		return eventos
				.stream()
				.map(e -> of(e))
				.collect(Collectors.toList());
	}

}
