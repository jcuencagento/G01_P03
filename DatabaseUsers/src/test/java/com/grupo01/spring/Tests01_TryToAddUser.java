package com.grupo01.spring;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

//import javax.persistence.Column;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo01.spring.controller.UserController;
import com.grupo01.spring.service.UsuarioService;
import com.grupo01.spring.model.Usuario;
import com.grupo01.spring.repository.UsuarioRepository;

@ContextConfiguration(classes={UsuarioRepository.class, UsuarioService.class, UserController.class})
///////////////// TEST NOT!! OK ////////////////////
@WebMvcTest(UserController.class)
public class Tests01_TryToAddUser {

    @Autowired
    private MockMvc mock;

    @MockBean
    private UsuarioService service;
    
    @MockBean
	private UsuarioRepository userRepo;
    
    //Guardar usuario nuevo lanza Bad Request
	@Test
    void contextLoads() throws Exception {
        // Given 
        //Usuario usu = new Usuario((long)15, "Prueba","01","gg@d.com","sdfghj", new Date());

        
        Usuario usu = new Usuario();
        usu.setUser_id((long) 15);
        usu.setNombre("Prueba");
        usu.setApellido("01");
        usu.setMail("gg@d.com");
        usu.setPassword("sdfghj");
        usu.setFechaActual( new Date());
        
        
        //when
        //when(service.crearUsuario(usu)).thenReturn(usu);

        //then
        // como meter el body bien (usu)
        mock.perform(post("/user/add")
            .content(asJsonString(usu))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk()); // devuelve 404 Not found o 400 Bad Request o NullPointerError, deberia 200

    }
	
	public static String asJsonString(final Object obj) {     
		try {         
			return new ObjectMapper().writeValueAsString(obj);     
			} catch (Exception e) {         
				throw new RuntimeException(e);     
				} 
		}

}