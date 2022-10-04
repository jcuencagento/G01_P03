package com.grupo01.spring.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

import com.grupo01.spring.model.Usuario;
import com.grupo01.spring.dto.UsuarioDTO;

@Data
public class UsuarioDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String nombrecompleto;
    private String mail;
    private String password;
    private String fecha;
    
    public static UsuarioDTO of(Usuario usuario) {  // transforma entity en dto
	    UsuarioDTO usuarioDTO = new UsuarioDTO();
	    usuarioDTO.setId(usuario.getUser_id());
	    usuarioDTO.setNombrecompleto(usuario.getNombre()+" "+usuario.getApellido());
	    usuarioDTO.setMail(usuario.getMail());
	    usuarioDTO.setPassword(usuario.getPassword());
	    usuarioDTO.setFecha(usuario.getFecha());
        return usuarioDTO;
    }

    public static List<UsuarioDTO> of(List<Usuario> usuarios) { // lista de usuarios
        return usuarios
        		.stream()
                .map(p -> of(p))
                .collect(Collectors.toList());
    }


}