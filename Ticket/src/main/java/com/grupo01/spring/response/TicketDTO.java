package com.grupo01.spring.response;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grupo01.spring.model.Ticket;
import com.grupo01.spring.model.TicketEvent;

import lombok.Data;

@Data
public class TicketDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(TicketDTO.class);

	
	private int ticket_id;
	private String user_mail;
	private List<EventoDTO> events;
	
	public static TicketDTO of(Ticket ticket) {
		log.info("------TICKET ADAPTER CON TICKET----");
		log.info("------TICKET ADAPTER CON TICKET----"+ticket.getTicket_id());
		log.info("------TICKET ADAPTER CON EVENTOS----"+ticket.getEvents().get(0).getNombre());
		TicketDTO t = new TicketDTO();
		
		t.setTicket_id(ticket.getTicket_id());
		t.setUser_mail(ticket.getUserticket().getMail());
		List<TicketEvent> aux = ticket.getEvents();
		log.info("------GET EVENTS----"+aux);
		List<EventoDTO> aux2 = EventoDTO.of(aux);
		log.info("------EVENTO DTO OF----"+aux2);
		t.setEvents(aux2);        ///ERRROR
		log.info("-------HE SALIDO DEL SET EVENTS-------");
        return t;
    }
    
	public static List<TicketDTO> of(List<Ticket> tickets) {
		return tickets
				.stream()
				.map(t -> of(t))
				.collect(Collectors.toList());
	}
	

}
