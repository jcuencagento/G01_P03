package com.grupo01.spring.service;

import java.util.List;
import java.util.Optional;
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
import com.grupo01.spring.model.Evento;

public interface EventService {

	public List<Evento> eventoListado();

<<<<<<< Updated upstream
	public Evento addEvento(Evento evento);

	public Optional<Evento> eventoByEvent_id(int event_id);
=======
	public Optional<Evento> eventoByEventId(int id);
>>>>>>> Stashed changes

}
