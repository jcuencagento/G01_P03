package com.grupo01.spring;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.grupo01.spring.controller.TicketController;
import com.grupo01.spring.controller.error.ListaVaciaException;
import com.grupo01.spring.model.Ticket;
import com.grupo01.spring.service.TicketService;

/////////// TEST OK ///////
@WebMvcTest(value= TicketController.class,  excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class Ttest02_ListadoVacio {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TicketService service;
	
	
	@ExceptionHandler(ListaVaciaException.class)
	@Test
	void contextLoads() throws Exception {
		List<Ticket> listaVacia = new ArrayList<Ticket>();
		
		when(service.listTicket()).thenReturn(listaVacia);
		
		mockMvc.perform(get("/ticket"))
		.andExpect(result -> assertTrue(result.getResolvedException() instanceof ListaVaciaException));
	}

}
