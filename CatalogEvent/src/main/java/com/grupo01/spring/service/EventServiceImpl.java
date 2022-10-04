package com.grupo01.spring.service;

import java.util.List;

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

}
