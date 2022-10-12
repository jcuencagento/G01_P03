package com.grupo01.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo01.spring.controller.TicketController;
import com.grupo01.spring.controller.error.TicketNotFoundException;
import com.grupo01.spring.controller.error.UserNotFoundException;
import com.grupo01.spring.feignclients.CatalogFeignClientEvent;
import com.grupo01.spring.feignclients.CatalogFeignClientUser;
import com.grupo01.spring.feignclients.FeignClientPasarela;
import com.grupo01.spring.model.Ticket;
import com.grupo01.spring.model.TicketEvent;
import com.grupo01.spring.model.UserTicket;
import com.grupo01.spring.repository.TicketEventRepo;
import com.grupo01.spring.repository.UserTicketRepo;
import com.grupo01.spring.repository.service.TicketRepo;
import com.grupo01.spring.response.EventoDTO;
import com.grupo01.spring.response.UserDTO;
import com.grupo01.spring.utils.Randomizador;

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
	
	@Autowired
	private FeignClientPasarela pasarelaFeign;
	

	@Override
	public List<Ticket> listTicket() {
		log.info("------------ESTOY EN LIST TICKET SERVICE------");
		return ticketRepo.findAll();
	}

	@Override
	public Optional<Ticket> findByTicketId(int ticket_id) {
		return ticketRepo.findByTicketId(ticket_id);
	}

	@Override
	public void addEvent(int ticket_id, int event_id) {
		final EventoDTO evento = eventFeign.getEvent(event_id); 
		String rangoPrecios = evento.getRangoPrecios();
		String[] rangos = rangoPrecios.split(",");
		int precio = Randomizador.generarNumAleatorio(Integer.parseInt(rangos[0]), Integer.parseInt(rangos[1]));
		this.addEvent(ticket_id, event_id, evento.getNombre(),evento.getDescLarga(), evento.getGenero(), rangoPrecios, precio);
	}
	
	public void addEvent(int ticket_id, int event_id, String nombre, String descLarga, String genero, String rangoPrecios, int precio) {
		final Ticket ticket = ticketRepo.findById(ticket_id).orElseThrow(TicketNotFoundException::new);
		ticket.setPrecio_total(precio);
		TicketEvent te = new TicketEvent();
		te.setTicket(ticket);
		te.setEvent_id(event_id);
		te.setNombre(nombre);
		te.setDescLarga(descLarga);
		te.setGenero(genero);
		te.setRangoPrecios(rangoPrecios);
		te.setPrecio(precio);
		ticketeventRepo.save(te);

	}

	@Override
	public void addTicket(String mail, String pwd) throws Exception {
		final UserDTO user = userFeign.login(mail,pwd).orElseThrow(UserNotFoundException::new);					//Si es login incorrecto se quedaria aqui con 403
		log.info("------------ADDTICKET SERVICE HE LOGEADO A="+user);
		
		UserTicket userticket = new UserTicket();
		userticket.setUser_id(user.getUser_id());
		userticket.setMail(mail);
		userticket.setToken(user.getToken());
		userticket = userticketRepo.save(userticket);
		System.out.println(userticket);
		log.info("------------ADDTICKET SERVICE CON USERTICKET="+userticket.getUserticket_id());
		
		Ticket ticket = new Ticket();
		ticket.setUserticket(userticket);
		ticket.setEvents(null);
		ticketRepo.save(ticket);
		log.info("------------ADDTICKET SERVICE CON TICKET CON USERTICKET ID="+ticket.getTicket_id());
	}

	@Override
	public String pay(int ticket_id) {
		final Ticket ticket = ticketRepo.findById(ticket_id).orElseThrow(TicketNotFoundException::new);
		final String respuesta = pasarelaFeign.pago(ticket.getTicket_id(), ticket.getPrecio_total(), ticket.getUserticket().getMail());
		return respuesta;
	}

	@Override
	public String getToken(int ticket_id) {
		final Ticket ticket = ticketRepo.findById(ticket_id).orElseThrow(TicketNotFoundException::new);
		return ticket.getUserticket().getToken();
	}

}
