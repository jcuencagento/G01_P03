package com.grupo01.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@Data
@Entity
@Table(name="ticketevent")
public class TicketEvent {
	
	@Id
	private int ticketevent_id;
	
	@JsonIgnoreProperties("events")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="ticket_id")
	private Ticket ticket;
	
	private int event_id;
	
	private String nombre;
	private String descLarga;
	private String genero;
	private String rangoPrecios;
	private int precio;
	//private String ciudad; vendra con recinto
}
