package com.grupo01.spring.dto;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@Schema(name="Ticket", description = "Clase Ticket. Esta clase es de tipo DTO")
public class PagoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Schema(name= "ticket_id", 
    		description = "Identificador único para el ticket", 
            example = "38", 
            required = true)
	private int ticket_id;
	private String mail;
	private int precio_total;
	
	@Schema(name= "status", 
    		description = "Definicion del estado del pago", 
            example = "Codigo: 200. Descripcion: Pago aceptado!", 
            required = true)
	private String status;
	

}
