package com.grupo01.spring.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class TicketDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int ticket_id;
	private String user_mail;
	private int precio_total;
	private List<EventoDTO> events;
	
	
}
