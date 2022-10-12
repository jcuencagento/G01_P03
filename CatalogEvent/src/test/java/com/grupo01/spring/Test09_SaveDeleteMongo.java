package com.grupo01.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.grupo01.spring.model.Evento;
import com.grupo01.spring.repository.EventRepo;

///////////////// TEST OK ////////////////////
@DataMongoTest
public class Test09_SaveDeleteMongo {
	
	@Autowired
	private EventRepo repo;
	
	@Test
	void contextLoads() {
		
		//Primero probamos save
		
		Evento e = new Evento(149, null, null, null, null, null, null, null, null, null);
		assertThat(repo.save(e).getNombre()).isNull();
		
		Evento eOK = new Evento(150, "ConciertoMJ", "Desc", "Ext", "Genero", "Cosas", "etc", "etc", "etc", null);
		assertThat(repo.save(eOK).getNombre()).isEqualTo(eOK.getNombre());
		
		repo.deleteBy(e.getEvent_id());
		repo.deleteBy(eOK.getEvent_id());
		
	}

}

