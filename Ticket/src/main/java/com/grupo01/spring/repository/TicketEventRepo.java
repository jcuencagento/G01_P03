package com.grupo01.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo01.spring.model.TicketEvent;

public interface TicketEventRepo extends JpaRepository<TicketEvent, Integer>{

}
