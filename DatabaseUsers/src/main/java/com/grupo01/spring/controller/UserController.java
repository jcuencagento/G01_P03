package com.grupo01.spring.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.grupo01.spring.controller.error.UserFoundException;
import com.grupo01.spring.dto.UsuarioDTO;
import com.grupo01.spring.model.Usuario;
import com.grupo01.spring.repository.UsuarioRepository;
import com.grupo01.spring.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/user")
@Tag(name = "usuario", description = "el usuario API")
public class UserController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private UsuarioRepository userRepo;
	
	@Operation(summary = "Registrar nuevo usuario", description = "El usuario rellena el formulario de registracion", tags= {"Usuario"})

	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UsuarioDTO crearUsuario(@RequestBody Usuario usuario) throws Exception {
		for(Usuario u: userRepo.findAll()) {
			if(usuario.getMail().equals(u.getMail())) throw new UserFoundException();		
		}
		usuario.setFechaActual(new Date());
		return UsuarioDTO.of(usuarioService.crearUsuario(usuario));
	}
	
}
