package com.grupo01.spring.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo01.spring.model.Evento;
import com.grupo01.spring.repository.EventRepo;

@org.springframework.transaction.annotation.Transactional
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
		return eventRepo.findByNombre(nombre.toLowerCase());
	}


	@Override
	public List<Evento> eventoByGenero(String genero) {
		log.info("------Evento por genero EventServiceImpl------");
		return eventRepo.findByGenero(genero.toLowerCase());
	}
	
	@Override
	public List<Evento> eventoByCiudad(String ciudad) {
		log.info("------Evento por ciudad EventServiceImpl------");
		return eventRepo.findByCiudad(ciudad.toLowerCase());
	}


	@Override
	public Evento editEvento(Evento actual, Evento editado) {
		log.info("------Evento editado EventServiceImpl------");
		editado.setEvent_id(actual.getEvent_id());
		eventRepo.deleteBy(actual.getEvent_id());
		return eventRepo.save(editado);
	}




}
