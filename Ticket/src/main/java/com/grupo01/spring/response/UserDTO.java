package com.grupo01.spring.response;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grupo01.spring.model.UserTicket;

@Data
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(UserDTO.class);

	private int user_id;
	private String mail;
	private String token;
	
	public static UserDTO of(UserTicket user) {
		log.info("--------Adapter User------");
		UserDTO u = new UserDTO();
		u.setUser_id(user.getUser_id());
		u.setMail(user.getMail());
		u.setToken(user.getToken());
		return u;
	}
	
	public static List<UserDTO> of(List<UserTicket> users) {
		log.info("----- Usuarios:" + users);
		return users.
				stream()
				.map(u -> of(u))
				.collect(Collectors.toList());
	}

}
