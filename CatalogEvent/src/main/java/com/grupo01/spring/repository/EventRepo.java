package com.grupo01.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.grupo01.spring.model.Evento;

@Repository
public interface EventRepo extends MongoRepository<Evento, Integer>{

	@Query("{'event_id':?0}")
	public Optional<Evento> findBy(int event_id);

	@Query(value="{'event_id':?0}", delete=true)
	public void deleteBy(int event_id);

	@Query("{'nombre':?0}")
	public List<Evento> findByNombre(String nombre);
	
	@Query("{'genero':?0}")
	public List<Evento> findByGenero(String genero);

	@Query("{'recinto.ciudad':?0}")
	public List<Evento> findByCiudad(String ciudad);

}
