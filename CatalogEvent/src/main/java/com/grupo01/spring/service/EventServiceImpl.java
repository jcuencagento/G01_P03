package com.grupo01.spring.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import com.grupo01.spring.model.Evento;
import com.grupo01.spring.repository.EventRepo;

@Transactional
@Service
public class EventServiceImpl implements EventService{
	
	private static final Logger log = LoggerFactory.getLogger(EventServiceImpl.class);
	
	@Autowired
	EventRepo eventRepo;

	@Override
	public List<Evento> eventoListado() {
		log.info("------Listado EventServiceImpl------");
		return eventRepo.findAll();
	}
	
	
	@Override
	public Optional<Evento> eventoByEvent_id(int event_id) {
		log.info("------Evento por id EventServiceImpl------");
		return eventRepo.findBy(event_id);
	}

	
	@Override
	public Evento addEvento(Evento evento) {
		log.info("------Add Evento EventServiceImpl------");
		return eventRepo.save(evento);
	}


	@Override
	public void deleteEvento(int event_id) {
		log.info("------Delete Evento EventServiceImpl------");
		eventRepo.deleteBy(event_id);
	}


	@Override
	public List<Evento> eventoByNombre(String nombre) {
		log.info("------Evento por nombre EventServiceImpl------");
		return eventRepo.findByNombre(nombre);
	}


	@Override
	public List<Evento> eventoByGenero(String genero) {
		log.info("------Evento por genero EventServiceImpl------");
		return eventRepo.findByGenero(genero);
	}


}
