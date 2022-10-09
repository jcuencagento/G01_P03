package com.grupo01.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

@ToString(exclude="ticket")
@Data
@Entity
@Table(name="userticket")
public class UserTicket {
	
	@Id
	private int userticket_id;
	
	private int user_id;
	private String mail;
	private String token;
	
	@OneToMany(mappedBy="userticket")
	private List<Ticket> ticket;
	
	
}
