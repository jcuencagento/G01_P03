package com.grupo01.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.grupo01.spring.repository.service.TicketRepo;


////////////////TEST OK //////////
@SpringBootTest
public class Ttest03_JpaRepo {

	@Autowired
	private TicketRepo repo;
	
	@Test
	void contextLoads() {
		assertThat(repo).isNotNull();
	}
	
}
