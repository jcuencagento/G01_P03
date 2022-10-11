package com.grupo01.spring.repository.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grupo01.spring.model.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {

	@Query("FROM Ticket WHERE ticket_id=?1")
	public Optional<Ticket> findByTicketId(int id);

}
