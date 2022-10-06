package com.grupo01.spring;

 

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

 

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

 

import com.grupo01.spring.controller.EventController;
import com.grupo01.spring.repository.EventRepo;
import com.grupo01.spring.service.EventService;

///////////////// TEST OK ////////////////////
@SuppressWarnings("unused")
@SpringBootTest
@AutoConfigureMockMvc
public class Test03_IdCorrecto {
	
    @Autowired
    private MockMvc mockMvc;
    
	@Autowired
    private EventService service;

    @Autowired
    private EventRepo repo;

    @Test
    void contextLoads() throws Exception {
        int event_id=0;
        mockMvc.perform(get("/evento/" + event_id))
        	.andDo(print())
        	.andExpect(status().isOk())
            .andExpect(content().string("{\"event_id\":0,\"nombre\":\"Vinarock\",\"descCorta\":\"Festival rock, rap, reggae.\",\"descLarga\":\"Festival rock, rap, reggae en Villarrobledo.\\n\",\"fecha\":\"30/04/2023\",\"hora\":\"16:00\",\"rangoPrecios\":\"40,100\",\"acceso\":\"+18\",\"recinto\":{\"nombre\":\"Recinto ferial.\",\"ciudad\":\"Villarrobledo\",\"direccion\":\"Afueras\",\"tipo\":\"Explanada\",\"aforo\":200000}}"));
    }
}
