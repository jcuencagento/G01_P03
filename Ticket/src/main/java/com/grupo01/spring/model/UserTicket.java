package com.grupo01.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="userticket")
public class UserTicket {
	
	@Id
	private int userticket_id;
	
	private int user_id;
	private String mail;
	//private String token;
	
	@OneToMany
	private List<Ticket> tickets;
	
	
}
