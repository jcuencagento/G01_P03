package com.grupo01.spring;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo01.spring.model.Usuario;
//import com.grupo01.spring.service.UsuarioService;
//import com.grupo01.spring.repository.UsuarioRepository;

///////////////// TEST OK ////////////////////
@SpringBootTest
@AutoConfigureMockMvc
public class Test02_AddUser {

    @Autowired
    private MockMvc mock;

    //@Autowired
    //private UsuarioService service;
    
    //@Autowired
    //private UsuarioRepository userRepo;

    
    //Guardar usuario nuevo 
    @Test
    void contextLoads() throws Exception {

    	// Given 
    	Usuario usu = new Usuario();
    	usu.setUser_id(17);
    	usu.setNombre("Prueba");
    	usu.setApellido("01_c");
    	usu.setMail("jdjh@.com");
    	usu.setPassword("sdfghj");
    	usu.setFechaActual(new Date());

    	// Then
    	mock.perform(post("/user/add/")
    			.content(asJson(usu))
    			.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
    	.andExpect(status().is2xxSuccessful());
    }


	public static String asJson(final Object obj) {     
		try {         
			return new ObjectMapper().writeValueAsString(obj);     
		} catch (Exception e) {         
			throw new RuntimeException(e);     
		} 
	}

}