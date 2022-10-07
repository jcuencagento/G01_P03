package com.grupo01.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo01.spring.model.UserTicket;

public interface UserTicketRepo extends JpaRepository<UserTicket, Integer>{

}
