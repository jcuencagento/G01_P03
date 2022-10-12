package com.grupo01.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo01.spring.controller.error.IncorrectPasswordException;
import com.grupo01.spring.controller.error.UserNotFoundException;
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
		
		return usuarioRepo.save(usuario);
	}
	
	@Override
    public Optional<Usuario> usuarioById(int user_id) {
        return usuarioRepo.findById(user_id);
    }
	
	@Override
    public Optional<Usuario> usuarioByMail(String mail) {
        return usuarioRepo.findByMail(mail);
    }

	@Override
	public List<Usuario> listUsuarios() {
		return usuarioRepo.findAll();
	}

	@Override
	public Usuario editUsuario(String mail, String pwd, Usuario usuario) {
		Usuario u_initial = usuarioRepo.findByMail(mail).orElseThrow(UserNotFoundException::new);
		if(u_initial.getPassword().equals(pwd)) {
			u_initial.setNombre(usuario.getNombre());
			u_initial.setApellido(usuario.getApellido());
			u_initial.setMail(usuario.getMail());
			u_initial.setPassword(usuario.getPassword());
		}else {
			throw new IncorrectPasswordException();
		}
		return u_initial;
	}

	@Override
	public void deleteUsuario(String mail, String pwd) {
		Usuario user = usuarioRepo.findByMail(mail).orElseThrow(UserNotFoundException::new);
		if(user.getPassword().equals(pwd)) {
			usuarioRepo.delete(user);
		}else {
			throw new IncorrectPasswordException();
		}
	}
	
}
