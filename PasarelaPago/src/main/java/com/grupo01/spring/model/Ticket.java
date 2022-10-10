package com.grupo01.spring.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@ToString(exclude = "events")
@Data
@Entity
public class Ticket {

	@Id
	private int ticket_id;

	@ManyToOne
	@JoinColumn(name = "userticket_id")
	private UserTicket userticket;

	private int precio_total;

	@OneToMany(mappedBy = "ticket")
	private List<TicketEvent> events;

}
