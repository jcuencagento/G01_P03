package com.grupo01.spring.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.grupo01.spring.controller.error.UserFoundException;
import com.grupo01.spring.dto.UsuarioDTO;
import com.grupo01.spring.model.Usuario;
import com.grupo01.spring.repository.UsuarioRepository;
import com.grupo01.spring.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;

@RestController
@RequestMapping("/user")
@Tag(name = "usuario", description = "el usuario API")
public class UserController {
	
	@Autowired
	@Schema(name = "usuarioService", description = "Instancia de la capa servicios. Inyectada automaticamente mediante la anotacion @Autowired")
	private UsuarioService usuarioService;
	
	@Autowired
	@Schema(name = "usuarioRepo", description = "Instancia de la capa repositoio. Inyectada automaticamente mediante la anotacion @Autowired")
	private UsuarioRepository userRepo;
	

	@Operation(summary = "Registrar nuevo usuario", description = "El usuario rellena el formulario de registro y crea el usuario. Si se crea correctamente devuelve 201", tags= {"Usuario"})
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Usuario creado.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Usuario.class)) }),
			  @ApiResponse(responseCode = "400", description = "Invalid mail supplied", 
			    content = @Content)})
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UsuarioDTO crearUsuario( @Parameter(name = "usuario", description = "usuario que llega por metodo post") 
	@RequestBody Usuario usuario) throws Exception {
		for(Usuario u: userRepo.findAll()) {
			if(usuario.getMail().equals(u.getMail())) throw new UserFoundException();		
		}
		usuario.setFechaActual(new Date());
		return UsuarioDTO.of(usuarioService.crearUsuario(usuario));
	}
	
}
