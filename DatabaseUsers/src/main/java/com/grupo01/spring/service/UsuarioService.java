package com.grupo01.spring.service;

import java.util.Optional;

import com.grupo01.spring.model.Usuario;

public interface UsuarioService {

	public Usuario crearUsuario(Usuario usuario) throws Exception;
	
	public Optional<Usuario> usuarioById(int user_id);
	
    public Optional<Usuario> usuarioByMail(String mail);

	//public Optional<Usuario> usuarioById(long user_id);

}
