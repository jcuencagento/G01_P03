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
import com.grupo01.spring.model.Recinto;
import com.grupo01.spring.service.EventService;

@WebMvcTest(EventController.class)
public class Test05_AltaCorrecta {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private EventService service;

	@Test
	void contextLoads() throws Exception {
		Recinto r = new Recinto("casa", "madrid", "avenida america", "area", 155);
		Evento e = new Evento(1, "electronica", "musica electronica", "musica electronica a tope de volumen",
				"2007/10/06", "20:15", "15,60", "si", r);

		when(service.addEvento(e)).thenReturn(e);
		mockMvc.perform(post("/evento/add/",e)).andExpect(status().isOk());
	}
}
