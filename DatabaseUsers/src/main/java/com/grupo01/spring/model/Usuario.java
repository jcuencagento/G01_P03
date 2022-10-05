package com.grupo01.spring.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Entity
@Table(name="usuarios")
@Schema(name="Usuario", description = "Clase Usuario")
public class Usuario {

	 @Schema(name= "id", 
	    		description = "Identificador único para el usuario", 
	            example = "38", 
	            required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long user_id;
	
	private String nombre;
	private String apellido;
	@Column(name = "mail", unique = true)
	private String mail;
	private String password;
	String fecha;


	//cambiamos el setter de fecha
	//a lo mejor nos llega un Date o un string, hablar con el resto del grupo 
	public void setFechaActual(Date fecha) {
		this.fecha = changeTimeStamp(fecha);
	}
	
	private String changeTimeStamp(Date d) {
		final DateFormat dateFormat= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return dateFormat.format(d);//el .format-> lo convierte en String


	}
	
}
