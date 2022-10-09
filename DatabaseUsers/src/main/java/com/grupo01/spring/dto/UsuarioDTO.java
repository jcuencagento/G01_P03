package com.grupo01.spring.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

import com.grupo01.spring.model.Usuario;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import com.grupo01.spring.dto.UsuarioDTO;

@Data
@Schema(name = "UsuarioDTO", description = "Objeto DTO para el paso a JSON. es prácticamente idéntico a la clase usuario ")
public class UsuarioDTO implements Serializable{

	@Schema (name="serialVersionUID", 
			description = "Valor para que funcione la serializacion.")
	private static final long serialVersionUID = 1L;
	
	@NotBlank@NotEmpty
	private int id;
	@NotBlank@NotEmpty
    private String nombrecompleto;
	@NotBlank@NotEmpty
    private String mail;
	@NotBlank@NotEmpty
    private String password;
	@NotBlank@NotEmpty
    private String fecha;
    
	@Operation(summary = "Convierte un usuario de tipo @Entity y devuelve uno tipo DTO")
    public static UsuarioDTO of(@Parameter(description = "Recibe un usuario de tipo Entity.") 
    Usuario usuario) {  // transforma entity en dto
	    UsuarioDTO usuarioDTO = new UsuarioDTO();
	    usuarioDTO.setId(usuario.getUser_id());
	    usuarioDTO.setNombrecompleto(usuario.getNombre()+" "+usuario.getApellido());
		usuarioDTO.setMail(usuario.getMail());	    
	    usuarioDTO.setPassword(usuario.getPassword());
	    usuarioDTO.setFecha(usuario.getFecha());
        return usuarioDTO;
    }

	@Operation(description = "Convierte una lista de usuarios de tipo @Entity y los devuelve convertidos en una lista de usuarios tipo DTO.")
    public static List<UsuarioDTO> of( @Parameter(description = "Recibe un array de usuarios tipo @Entity") List<Usuario> usuarios) { // lista de usuarios
        return usuarios
        		.stream()
                .map(p -> of(p))
                .collect(Collectors.toList());
    }


}