package com.grupo01.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.grupo01.spring.dto.UsuarioDTO;
import com.grupo01.spring.model.Usuario;
import com.grupo01.spring.service.UsuarioService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UsuarioDTO crearUsuario(@RequestBody Usuario usuario) throws Exception {
		
		
		
		return UsuarioDTO.of(usuarioService.crearUsuario(usuario));
		
	}
	
}
