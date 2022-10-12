package com.grupo01.spring.service;

import java.util.List;
import java.util.Optional;

import com.grupo01.spring.model.Usuario;

public interface UsuarioService {

	public Usuario crearUsuario(Usuario usuario) throws Exception;
	
	public Optional<Usuario> usuarioById(int user_id);
	
    public Optional<Usuario> usuarioByMail(String mail);

	public List<Usuario> listUsuarios();

	public Usuario editUsuario(String mail, String pwd, Usuario usuario);

	public void deleteUsuario(String mail, String pwd);
}
