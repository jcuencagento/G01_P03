package com.grupo01.spring;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo01.spring.controller.EventController;
import com.grupo01.spring.model.Evento;
import com.grupo01.spring.model.Recinto;
import com.grupo01.spring.repository.EventRepo;
import com.grupo01.spring.service.EventService;

///////////////// TEST OK ////////////////////
//FALTA DELETE//
@SuppressWarnings("unused")
@SpringBootTest
@AutoConfigureMockMvc
public class Test05_AltaDeleteCorrecta {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private EventController controller;
	
	@Autowired
	private EventService service;
	
	@Autowired
	private EventRepo repo;

	@Test
	void contextLoads() throws Exception {
		Recinto r = new Recinto("casa", "madrid", "avenida america", "area", 155);
		Evento e = new Evento(1, "electronica", "musica electronica", "musica electronica a tope de volumen", "electronica",
				"2007/10/06", "20:15", "15,60", "si", r);

		//Comprobamos que se introduce correctamente
		mockMvc.perform(post("/evento/add/")
				.content(asJson(e))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(""));
		
		//Comprobamos que lo borramos correctamente
		mockMvc.perform(delete("/evento/delete/")
				.content(asJson(e))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
	}
	
	public static String asJson(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
	   	} catch (Exception e) {
	   		throw new RuntimeException(e);
	    }
	 }
}
