package com.grupo01.spring.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;
import lombok.AllArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@AllArgsConstructor
@Entity
@Table(name="usuarios")
@Schema(name="Usuario", description = "Clase Usuario. Esta clase es de tipo @Entity")
public class Usuario {

	 @NotBlank@NotEmpty
	 @Schema(name= "id", 
	    		description = "Identificador único para el usuario", 
	            example = "38", 
	            required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long user_id;
	@NotBlank@NotEmpty
	private String nombre;
	@NotBlank@NotEmpty
	private String apellido;
	//@Info(description = "Este campo tiene que ser único, para evitar valores duplicados. Para controlarlo, se aplica el campo unique=true en la anotacion @Column")
	@NotBlank@NotEmpty 
	@Schema(name = "mail", 
	description = "Campo de correo electrónico. Este campo tiene que ser único, para evitar valores duplicados. Para controlarlo, se aplica el campo unique=true en la anotacion @Column",
	example = "prueba@prueba.com" )
	@Column(name = "mail", unique = true)
	private String mail;
	@NotBlank@NotEmpty
	private String password;
	String fecha;



	public Usuario() {
		super();
	}

	//cambiamos el setter de fecha
	//a lo mejor nos llega un Date o un string, hablar con el resto del grupo
	@Operation (summary = "cambia de formato la fecha en la que se crea un usuario.")
	public void setFechaActual(Date fecha) {
		this.fecha = changeTimeStamp(fecha);
	}

	
	@Operation (description = "Formatea la fecha que llega a un formato válido para la inserición en la base de datos.")

	private String changeTimeStamp(Date d) {
		final DateFormat dateFormat= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return dateFormat.format(d);//el .format-> lo convierte en String
	}	
	
}
