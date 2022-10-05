package com.grupo01.spring.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo01.spring.controller.error.UserFoundException;
import com.grupo01.spring.model.Usuario;
import com.grupo01.spring.repository.UsuarioRepository;

@Transactional
@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	public Usuario crearUsuario(Usuario usuario) throws Exception {
		
		//Optional<Usuario> duplicado= Optional.ofNullable(usuarioRepo.findByMail(usuario.getMail()).orElse(null));
		//Usuario dupe= duplicado.get();
		//if (dupe.getMail().equals(usuario.getMail())) {
		//	throw new UserFoundException();
		//} 
		return usuarioRepo.save(usuario);
	}
}
