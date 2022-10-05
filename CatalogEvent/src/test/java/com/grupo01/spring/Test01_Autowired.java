package com.grupo01.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.grupo01.spring.controller.EventController;


///////////////// TEST OK ////////////////////
@SpringBootTest
public class Test01_Autowired {
	
	@Autowired
	EventController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
