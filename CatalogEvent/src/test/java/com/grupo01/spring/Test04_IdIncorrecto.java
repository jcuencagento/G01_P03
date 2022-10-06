package com.grupo01.spring;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.grupo01.spring.controller.EventController;
import com.grupo01.spring.repository.EventRepo;
import com.grupo01.spring.service.EventService;

 
///////////////// TEST OK ////////////////////
@WebMvcTest(EventController.class)
public class Test04_IdIncorrecto {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService service;
    
    @MockBean
    private EventRepo repo;

    @Test
    void contextLoads() throws Exception {
        String event_id = "papatas";
        mockMvc.perform(get("/evento/" + event_id))
        	.andExpect(status().isBadRequest());
    }
}