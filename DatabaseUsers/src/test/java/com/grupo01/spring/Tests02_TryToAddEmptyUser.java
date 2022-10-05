package com.grupo01.spring;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.grupo01.spring.controller.UserController;

import com.grupo01.spring.model.Usuario;
import com.grupo01.spring.repository.UsuarioRepository;
import com.grupo01.spring.service.UsuarioService;

//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
///////////////// TEST OK ////////////////////
@WebMvcTest(UserController.class)
public class Tests02_TryToAddEmptyUser {

	@Autowired
    private MockMvc mock;
	
	@MockBean
	private UsuarioService usuarioService;
	
	@MockBean
	private UsuarioRepository userRepo;

	//OK Guardar usuario nuevo vacia lanza Bad Request
	@Test
    void contextLoads() throws Exception {
        Usuario usuarioVacio = null;

        when(usuarioService.crearUsuario(usuarioVacio)).thenReturn(usuarioVacio);

        mock.perform(post("/user/add",usuarioVacio))
            .andExpect(status().isBadRequest());

    }

}