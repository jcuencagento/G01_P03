package com.grupo01.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@Entity
@Table(name="ticketevent")
@Schema(name="TicketEvent", description = "Clase TicketEvent. Esta clase es de tipo @Entity")
public class TicketEvent {
	
	@Id
	private int ticketevent_id;
	
	@JsonIgnoreProperties("events")
	@ManyToOne
	@JoinColumn(name="ticket_id")
	private Ticket ticket;
	
	private int event_id;
	
	private String nombre;
	private String descLarga;
	private String genero;
	private String rangoPrecios;
	private int precio;

}
