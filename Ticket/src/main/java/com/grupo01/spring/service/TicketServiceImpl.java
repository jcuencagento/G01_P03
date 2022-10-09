package com.grupo01.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo01.spring.controller.TicketController;
import com.grupo01.spring.feignclients.CatalogFeignClientEvent;
import com.grupo01.spring.feignclients.CatalogFeignClientUser;
import com.grupo01.spring.model.Ticket;
import com.grupo01.spring.model.TicketEvent;
import com.grupo01.spring.model.UserTicket;
import com.grupo01.spring.repository.TicketEventRepo;
import com.grupo01.spring.repository.UserTicketRepo;
import com.grupo01.spring.repository.service.TicketRepo;
import com.grupo01.spring.response.EventoDTO;
import com.grupo01.spring.response.UserDTO;

@Transactional
@Service
public class TicketServiceImpl implements TicketService{
	
	private static Logger log = LoggerFactory.getLogger(TicketController.class);
	
	@Autowired
	private TicketRepo ticketRepo;
	
	@Autowired
	private UserTicketRepo userticketRepo;
	
	@Autowired
	private TicketEventRepo ticketeventRepo;
	
	@Autowired
	private CatalogFeignClientEvent eventFeign;
	
	@Autowired
	private CatalogFeignClientUser userFeign;
	

	@Override
	public List<Ticket> listTicket() {
		log.info("------------ESTOY EN LIST TICKET SERVICE------");
		return ticketRepo.findAll();
	}

	@Override
	public Optional<Ticket> findByTicketId(int id) {
		return ticketRepo.findById(id);
	}

	@Override
	public void addEvent(int ticket_id, int event_id, int cant) {
		final EventoDTO evento = eventFeign.getEvent(event_id); 
		this.addEvent(ticket_id, event_id, evento.getNombre(), cant);
	}
	
	public void addEvent(int ticket_id, int event_id, String nombre, int cant) {
		final Ticket ticket = ticketRepo.findById(ticket_id).orElseThrow();
		
		for(int i=0; i<cant; i++) {
			TicketEvent te = new TicketEvent();
			te.setTicket(ticket);
			te.setEvent_id(event_id);
			te.setNombre(nombre);
			ticketeventRepo.save(te);
		}
	}

	@Override
	public void addTicket(String mail, String pwd) throws Exception {
		final UserDTO user = userFeign.login(mail,pwd);					//Si es login incorrecto se quedaria aqui con 403
		
		log.info("------------ADDTICKET SERVICE HE LOGEADO A="+user);
		
		Ticket ticket = new Ticket();
		UserTicket userticket = new UserTicket();
		
		userticket.setUser_id(user.getUser_id());
		userticket.setMail(mail);
		userticket.setToken(user.getToken());
		userticketRepo.save(userticket);
		
		log.info("------------ADDTICKET SERVICE CON USERTICKET="+userticket.getUserticket_id());
		
		ticket.setUserticket(userticket);
		ticket.setEvents(null);

		
		ticketRepo.save(ticket);
		
		log.info("------------ADDTICKET SERVICE CON TICKET CON USERTICKET ID="+ticket.getTicket_id());
	}
	

}
