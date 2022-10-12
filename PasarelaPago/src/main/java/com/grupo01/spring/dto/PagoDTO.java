package com.grupo01.spring.dto;

import java.io.Serializable;

import com.grupo01.spring.model.PaymentStatus;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class PagoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int ticket_id;
	private String mail;
	private int precio_total;
	private PaymentStatus status;
	

}
