package com.grupo01.spring.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import io.swagger.v3.oas.annotations.media.Schema;

@Document(collection = "events")
@Data
@AllArgsConstructor
@Schema(name = "Evento", description = "Clase Evento")
public class Evento {

	@Schema(name = "id", description = "Identificador único para el evento", example = "10", required = true)
	@Id
	// @Column(name="event_id")
	private int event_id;

	private String nombre;
	private String descCorta;
	private String descLarga;
	private String fecha;
	private String hora;
	private String rangoPrecios;
	private String acceso;
	private Recinto recinto;

}
