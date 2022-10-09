package com.grupo01.spring.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.authority.AuthorityUtils;

import org.springframework.security.core.GrantedAuthority;
import com.grupo01.spring.model.Usuario;
import com.grupo01.spring.utils.Tools;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Table(name="userticket")
@Schema(name = "UsuarioTokenDTO", description = "Objeto DTO para pasar la info sesion ")
public class UserTicketDTO implements Serializable{
	
	@Schema (name="serialVersionUID", 
			description = "Valor para que funcione la serializacion.")
	private static final long serialVersionUID = 1L;
	
	@NotBlank@NotEmpty
	private int user_id;
	@NotBlank@NotEmpty
    private String mail;
	@NotBlank@NotEmpty
    private String token;
	
	
	@Operation(summary = "Convierte un usuario de tipo @Entity y devuelve uno tipo DTO")
    public static UserTicketDTO of(@Parameter(description = "Recibe un usuario de tipo Entity.")  Usuario usuario) {  // transforma entity en dto
		UserTicketDTO userTicketDTO = new UserTicketDTO();
		userTicketDTO.setUser_id(usuario.getUser_id());
		userTicketDTO.setMail(usuario.getMail());	    
		userTicketDTO.setToken(getJWTToken(usuario.getNombre()));
        return userTicketDTO;
    }

	@Operation(description = "Convierte una lista de usuarios de tipo @Entity y los devuelve convertidos en una lista de usuarios tipo DTO.")
    public static List<UserTicketDTO> of( @Parameter(description = "Recibe un array de usuarios tipo @Entity") List<Usuario> usuarios) { // lista de usuarios
		 return usuarios
	        		.stream()
	                .map(p -> of(p))
	                .collect(Collectors.toList());
    }	

	@SuppressWarnings("deprecation")
	public static String getJWTToken(String username) {

		String secretKey = "LucaTicketGrupo01LucaTicketGrupo01LucaTicketGrupo01LucaTicketGrupo01LucaTicketGrupo01LucaTicketGrupo01";
		String palabraDeControl = "LucaTicket";

		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts
				.builder()
				.setId(Tools.getRandomNumberString()) //la primera parte de token
				.setSubject(username) // 2a parte de token
				//Indicamos personas autorizadas
				.claim("authorities",
						grantedAuthorities.stream()
						.map(GrantedAuthority::getAuthority)
						.collect(Collectors.toList())) // devuelve la lista de autoridades
				.setIssuedAt(new Date(System.currentTimeMillis())) //fecha - 2a parte de token
				//Marcamos la fecha de experacion a 10 minutos
				.setExpiration(new Date(System.currentTimeMillis() + 600000)) // expira en 10 minutos 
				.signWith(SignatureAlgorithm.HS512,  //podriamos cambiarlo
						secretKey.getBytes()).compact(); 

		//Añado una palabra para tener el control y saber que es un token propio de la app
		return palabraDeControl +" "+ token;
	}
	

}
