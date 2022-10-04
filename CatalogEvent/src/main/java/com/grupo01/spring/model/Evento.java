package com.grupo01.spring.model;
import lombok.Data;

import javax.persistence.Id;
//import javax.persistence.Column;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="events")
@Data
public class Evento {
	
	@Id
	//@Column(name="event_id")
	private int event_id;
	
	private String nombre;
	private String descCorta;
	private String descLarga;
	private String fecha;
	private String hora;
	private String rangoPrecios;
	private String acceso;
	private Recinto recinto;
	

}
