package com.grupo01.spring;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.grupo01.spring.controller.EventController;
import com.grupo01.spring.controller.error.ListaVaciaException;
import com.grupo01.spring.model.Evento;
import com.grupo01.spring.service.EventService;

/////// TEST OK //////////////
@WebMvcTest(EventController.class)
public class Test02_ListadoVacio {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EventService service;

	
	@ExceptionHandler(ListaVaciaException.class)
	@Test
	void contextLoads() throws Exception {
		List<Evento> listaVacia = new ArrayList<Evento>();
		
		when(service.eventoListado()).thenReturn(listaVacia);
		
		mockMvc.perform(get("/evento"))
		.andExpect(result -> assertTrue(result.getResolvedException() instanceof ListaVaciaException));
	}
	

}
