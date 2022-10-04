package com.grupo01.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	private UsuarioDTO crearUsuario(Usuario usuario) {
		Usuario us = new Usuario();

		us.setID(usuario.getID);
		us.setNombre(usuario.getNombre);
		us.setApellido(usuario.getApellido);
		us.setMail(usuario.getMail);
		us.setPassword(usuario.getPassword);
		us.setFecha(usuario.getFecha);

		usuarioRepo.save(us);
	}
}
