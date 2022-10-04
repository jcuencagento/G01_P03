package com.grupo01.spring.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFecha() {
		return fecha;
	}

	//cambiamos el setter de fecha
	//a lo mejor nos llega un Date o un string, hablar con el resto del grupo 
	public void setFecha(Date fecha) {
		this.fecha = this.changeTimeStamp(fecha);
	}
	
	private String changeTimeStamp(Date d) {
		final DateFormat dateFormat= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return dateFormat.format(d);//el .format-> lo convierte en String


	}
	
}
