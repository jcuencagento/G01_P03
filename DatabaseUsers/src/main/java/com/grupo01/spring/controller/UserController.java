package com.grupo01.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.grupo01.spring.model.Usuario;
import com.grupo01.spring.repository.UsuarioRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioAdapter usuarioAdapter;
	
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void crearUsuario(@RequestBody String nombre, 
			@RequestBody String apellido,
			@RequestBody String mail,
			@RequestBody String password) {
		
		Usuario user= new Usuario();
		usuarioService.add(user);
		
	}
	
}
