package com.grupo01.spring.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.grupo01.spring.model.Evento;

@Repository
public interface EventRepo extends MongoRepository<Evento, Integer>{

}
