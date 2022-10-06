package com.grupo01.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.grupo01.spring.controller.UserController;

///////////////// TEST OK ////////////////////
@SpringBootTest
public class Test01_Autowired {

	@Autowired
	UserController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isInstanceOf(UserController.class);
		assertThat(controller).isNotNull();
	}
}
