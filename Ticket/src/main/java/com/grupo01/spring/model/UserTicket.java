package com.grupo01.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@ToString(exclude="ticket")
@Data
@Entity
@Table(name="userticket")
@Schema(name="UserTicket", description = "Clase UserTicket. Esta clase es de tipo @Entity")
public class UserTicket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int userticket_id;
	
	private int user_id;
	private String mail;
	private String token;
	
	@OneToMany(mappedBy="userticket")
	private List<Ticket> ticket;
	
	
}
