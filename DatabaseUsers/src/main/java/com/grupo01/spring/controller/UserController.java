package com.grupo01.spring.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.grupo01.spring.controller.error.IncorrectPasswordException;
import com.grupo01.spring.controller.error.NullMailException;
import com.grupo01.spring.controller.error.NullNameException;
import com.grupo01.spring.controller.error.NullPassException;
import com.grupo01.spring.controller.error.UserFoundException;
import com.grupo01.spring.controller.error.UserNotFoundException;

import com.grupo01.spring.dto.UserTicketDTO;
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
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	@Schema(name = "usuarioService", description = "Instancia de la capa servicios. Inyectada automaticamente mediante la anotacion @Autowired")
	private UsuarioService usuarioService;
	
	@Autowired
	@Schema(name = "usuarioRepo", description = "Instancia de la capa repositoio. Inyectada automaticamente mediante la anotacion @Autowired")
	private UsuarioRepository userRepo;
	

	@Operation(summary = "Registrar nuevo usuario", description = "El usuario rellena el formulario de registro y crea el usuario. Si se crea correctamente devuelve 201", tags= {"Usuario"})
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "201", description = "Usuario creado.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Usuario.class)) }),
			  @ApiResponse(responseCode = "400", description = "Invalid mail supplied", 
			    content = @Content)})
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UsuarioDTO crearUsuario( @Parameter(name = "usuario", description = "usuario que llega por metodo post") 
	@RequestBody Usuario usuario) throws Exception {
		//if(usuario.getNombre().isEmpty() || usuario.getNombre().isBlank()|| usuario.getNombre()==null) throw new NullNameException();
		if(usuario.getNombre()==null||usuario.getNombre().isEmpty() || usuario.getNombre().isBlank()) throw new NullNameException();
		if(usuario.getPassword()==null|| usuario.getPassword().isEmpty() || usuario.getPassword().isBlank() ) throw new NullPassException();
		if(usuario.getMail()==null|| usuario.getMail().isEmpty() || usuario.getMail().isBlank()) throw new NullMailException();
		
		for(Usuario u: userRepo.findAll()) {
			if(usuario.getMail().equals(u.getMail())) throw new UserFoundException();	
		}
		usuario.setFechaActual(new Date());
		return UsuarioDTO.of(usuarioService.crearUsuario(usuario));
	}
	
	@Operation(summary = "Registrar nuevo usuario", description = "El usuario rellena el formulario de mail y password y hace login. Si se acepta devuelve 202", tags= {"Usuario"})
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "202", description = "Usuario aceptado.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Usuario.class)) }),
			  @ApiResponse(responseCode = "404", description = "Not found", 
			    content = @Content)})
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@PostMapping("/login") 
	public Optional<UserTicketDTO> login(@RequestParam("mail") String mail, @RequestParam("pwd") String pwd) {
		
        log.info("----Login de usuario en UserController----");
		
		Usuario user = usuarioService.usuarioByMail(mail).orElseThrow(UserNotFoundException::new);
		log.info("----Login de usuario "+user+" en UserController----");
		if (pwd.equals(user.getPassword())) {
			UserTicketDTO utDTO = UserTicketDTO.of(user);
	        log.info("----Login de usuario correcto en UserController----> "+utDTO);
			return Optional.ofNullable(utDTO); //un dto ticket	
		} else {
		   throw new IncorrectPasswordException();
		}	
		
	}
	
	@Operation(summary = "Listar usuarios", description = "Debe estar logeado", tags= {"Usuario"})
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Lista de usuarios encontrada.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Usuario.class)) }),
			  @ApiResponse(responseCode = "404", description = "Lista no encontrada", 
			    content = @Content)})
	@GetMapping("")
    public List<UsuarioDTO> listUsuarios() {
        log.info("----Listado de usuarios en UserController----");
        return UsuarioDTO.of(usuarioService.listUsuarios()); 
    }
	

	@Operation(summary = "Usuario por id", description = "Debe estar logeado e introducir un id para ver sus datos", tags= {"Usuario"})
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Usuario encontrado.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Usuario.class)) }),
			  @ApiResponse(responseCode = "404", description = "Usuario no encontrado", 
			    content = @Content)})
	@GetMapping("/{user_id}")
    public UsuarioDTO usarioById(@PathVariable int user_id) {
        log.info("----Listado por id de usuario en UserController----");
        return UsuarioDTO.of(usuarioService.usuarioById(user_id).orElseThrow(UserNotFoundException::new)); 
    }
	
	@Operation(summary = "Editar usuario logeandote", description = "Debe logearse para editar", tags= {"Usuario"})
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Usuario encontrado.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Usuario.class)) }),
			  @ApiResponse(responseCode = "404", description = "Usuario no encontrado", 
			    content = @Content)})
	@PutMapping("/{user_id}/edit")
	public UsuarioDTO editUsuario(@RequestParam String mail, @RequestParam String pwd,
			@RequestBody Usuario usuario) {
		log.info("----Editado de usuario en UserController----");
		return UsuarioDTO.of(usuarioService.editUsuario(mail, pwd, usuario));
	}
	
	@Operation(summary = "Dar de baja un usuario", description = "Debe logearse para darse de baja", tags= {"Usuario"})
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Usuario dado de baja.", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Usuario.class)) }),
			  @ApiResponse(responseCode = "404", description = "Usuario no encontrado", 
			    content = @Content)})
	@DeleteMapping("/delete")
	public void deleteUsuario(@RequestParam String mail, @RequestParam String pwd) {
		log.info("----Dar de baja un usuario en UserController----");
		usuarioService.deleteUsuario(mail, pwd);
	}
	
	


}

