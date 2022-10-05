package com.grupo01.spring;



import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.grupo01.spring.controller.EventController;
import com.grupo01.spring.model.Evento;
import com.grupo01.spring.service.EventService;

@WebMvcTest(EventController.class)
public class Test06_AltaIncorrecta {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private EventService service;
	@Test
	void contextLoads() throws Exception {
		Evento e=null;
		when(service.addEvento(e)).thenReturn(e);
		mockMvc.perform(post("/evento/add/",e)).andExpect(status().isBadRequest());
	}
}


