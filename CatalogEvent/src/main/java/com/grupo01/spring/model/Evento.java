package com.grupo01.spring.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.mapping.Document;
import io.swagger.v3.oas.annotations.media.Schema;

@Document(collection = "events")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Evento", description = "Clase Evento")
public class Evento {

	@Schema(name = "id", description = "Identificador único para el evento", example = "10", required = true)
	private int event_id;

	private String nombre;
	private String descCorta;
	private String descLarga;
	private String genero;
	private String fecha;
	private String hora;
	private String rangoPrecios;
	private String acceso;
	
	@Schema(name = "recinto", 
			description = "Campo de recinto. Es un objeto con atributos nombre, ciudad, direccion, tipo y aforo",
			example = "["
					+ "nombre: \"sala x\""
					+ "ciudad: \"Madrid\""
					+ "direccion: \"C/Humanes\""
					+ "tipo: \"sala\""
					+ "aforo: 2000"
					+ "]" )
	private Recinto recinto;

}
