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
import com.grupo01.spring.repository.TicketEventRepo;
import com.grupo01.spring.repository.UserTicketRepo;
import com.grupo01.spring.repository.service.TicketRepo;
import com.grupo01.spring.response.EventoDTO;

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
	
	

}
