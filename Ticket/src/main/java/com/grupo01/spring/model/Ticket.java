package com.grupo01.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@ToString(exclude="events")
@Data
@Entity
@Schema(name="Ticket", description = "Clase Ticket. Esta clase es de tipo @Entity")
public class Ticket {
	
	@Schema(name= "ticket_id", 
    		description = "Identificador único para el ticket", 
            example = "38", 
            required = true)
	@Id
	private int ticket_id;
	
	@ManyToOne
	@JoinColumn(name="userticket_id")
	private UserTicket userticket;
	
	private int precio_total;

	@JsonIgnoreProperties("ticket")
	@OneToMany(mappedBy="ticket")
	private List<TicketEvent> events;

}
