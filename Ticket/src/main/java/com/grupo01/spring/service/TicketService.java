package com.grupo01.spring.service;

import java.util.List;
import java.util.Optional;

import com.grupo01.spring.model.Ticket;
public interface TicketService {
	
	public List<Ticket> listTicket();
	
	public Optional<Ticket> findByTicketId(int id);
	
	public void addEvent(int ticket_id, int event_id, int cant);

}


