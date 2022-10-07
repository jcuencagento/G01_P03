package com.grupo01.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="ticketevent")
public class TicketEvent {
	
	@Id
	private int ticketevent_id;
	
	@ManyToOne()
	@JoinColumn(name="ticket_id")
	private Ticket ticket;
	
	private int event_id;
	
	private String nombre; ///Luego pondremos el resto atributos

}
