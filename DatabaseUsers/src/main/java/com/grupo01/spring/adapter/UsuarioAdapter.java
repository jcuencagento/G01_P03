package com.grupo01.spring.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class UsuarioAdapter {
	
	 public UsuarioDTO of(Usuario usuario) {  // transforma entity en dto
		    UsuarioDTO usuarioDTO = new UsuarioDTO();
		    usuarioDTO.setId(usuario.getId());
		    usuarioDTO.setNombre(usuario.getNombre());
		    suarioDTO.setName(usuario.getName());
	        return usuarioDTO;
	    }

	    public List<UsuarioDTO> of(List<Usuario> usuarios) { // lista de usuarios
	        return usuarios
	        		.stream()
	                .map(p -> of(p))
	                .collect(Collectors.toList());
	    }
     
}
