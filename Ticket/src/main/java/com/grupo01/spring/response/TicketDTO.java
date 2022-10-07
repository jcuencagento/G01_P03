package com.grupo01.spring.response;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grupo01.spring.model.Ticket;

import lombok.Data;

@Data
public class TicketDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(TicketDTO.class);

	
	private int ticket_id;
	private String user_mail;
	private List<EventoDTO> events;
	
	public static TicketDTO of(Ticket ticket) {
		log.info("------Ticket Adapter------");
		TicketDTO t = new TicketDTO();
		
		t.setTicket_id(ticket.getTicket_id());
		t.setUser_mail(ticket.getUser().getMail());
		t.setEvents(EventoDTO.of(ticket.getEvents()));

        return t;
    }
    
	public static List<TicketDTO> of(List<Ticket> tickets) {
		return tickets
				.stream()
				.map(t -> of(t))
				.collect(Collectors.toList());
	}
	

}
