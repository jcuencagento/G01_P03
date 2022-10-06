package com.grupo01.spring;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo01.spring.controller.error.NullNameException;
import com.grupo01.spring.model.Usuario;
import com.grupo01.spring.repository.UsuarioRepository;
import com.grupo01.spring.service.UsuarioService;

@SpringBootTest
@AutoConfigureMockMvc
public class Test03_AddUserNullName {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private UsuarioRepository repo;
	
	@Test
	void contextLoads() throws Exception {
		Usuario u = new Usuario();
		u.setUser_id((long) 1);
		u.setNombre("");//funciona con null y "    "
		u.setApellido("gomez");
		u.setMail("g@g.com");
		u.setPassword("dsklj");
		u.setFechaActual(new Date());
		
		
		mockMvc.perform(post("/user/add")
				.content(asJson(u))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotAcceptable());
		
	}
	

	public static String asJson(final Object obj) {     
		try {         
			return new ObjectMapper().writeValueAsString(obj);     
			} catch (Exception e) {         
				throw new RuntimeException(e);     
				} 
		}
}
