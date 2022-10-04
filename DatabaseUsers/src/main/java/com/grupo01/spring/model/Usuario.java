package com.grupo01.spring.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	
	private String nombre;
	private String apellido;
	private String mail;
	private String password;
	private String fecha;
	
	

	public Usuario(String nombre, String apellido, String mail, String password, String fecha) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.password = password;
		this.setFecha(new Date());
	}

	//cambiamos el setter de fecha
	//a lo mejor nos llega un Date o un string, hablar con el resto del grupo 
	public void setFecha(Date fecha) {
		this.fecha = changeTimeStamp(fecha);
	}
	
	private String changeTimeStamp(Date d) {
		final DateFormat dateFormat= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return dateFormat.format(d);//el .format-> lo convierte en String


	}
	
}
