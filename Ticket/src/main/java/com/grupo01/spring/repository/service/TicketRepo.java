package com.grupo01.spring.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo01.spring.model.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {

}
