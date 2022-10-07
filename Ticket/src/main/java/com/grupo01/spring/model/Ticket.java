package com.grupo01.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="ticket")
public class Ticket {
	
	@Id
	private int ticket_id;
	
	@ManyToOne
	@JoinColumn(name="userticket_id")
	private UserTicket user;

	@OneToMany(mappedBy="ticket")
	private List<TicketEvent> events;

}
