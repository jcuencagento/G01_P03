package com.grupo01.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo01.spring.model.Usuario;
import com.grupo01.spring.repository.UsuarioRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@Transactional
@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Operation(summary= "Crea y añade un usuario nuevo. lo añade en la base de datos mediante la llamada al metodo save().")
	public Usuario crearUsuario(@Parameter(description= "Usuario a añadir. Recibido desde el control.") 
								Usuario usuario) throws Exception {
		
		//Optional<Usuario> duplicado= Optional.ofNullable(usuarioRepo.findByMail(usuario.getMail()).orElse(null));
		//Usuario dupe= duplicado.get();
		//if (dupe.getMail().equals(usuario.getMail())) {
		//	throw new UserFoundException();
		//} 
		return usuarioRepo.save(usuario);
	}
}
