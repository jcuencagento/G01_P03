package com.grupo01.spring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@ToString(exclude="events")
@Data
@Entity
public class Ticket {
	
	@Id
	private int ticket_id;
	
	
	@ManyToOne
	@JoinColumn(name="userticket_id")
	private UserTicket userticket;
	
	private int precio_total;

	@JsonIgnoreProperties("ticket")
	@OneToMany(mappedBy="ticket", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<TicketEvent> events;
	
}
