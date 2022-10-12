package com.grupo01.spring.service;

import java.util.List;
import java.util.Optional;

import com.grupo01.spring.model.Ticket;
import com.grupo01.spring.response.PagoDTO;
public interface TicketService {
	
	public List<Ticket> listTicket();
	
	public Optional<Ticket> findByTicketId(int id);
	
	public void addEvent(int ticket_id, int event_id);

	public void addTicket(String mail, String pwd) throws Exception;

	public PagoDTO pay(int ticket_id);

	public String getToken(int ticket_id);

}


