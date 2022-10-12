package com.grupo01.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grupo01.spring.controller.TicketController;

public class Ttest01_Autowired {
	
	@Autowired
	TicketController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isInstanceOf(TicketController.class);
	}
	

}
