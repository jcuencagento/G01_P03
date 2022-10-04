package com.grupo01.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo01.spring.model.Usuario;
import com.grupo01.spring.repository.UsuarioRepository;

@Transactional
@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	public Usuario crearUsuario(Usuario usuario) {
		return usuarioRepo.save(usuario);
	}
}
