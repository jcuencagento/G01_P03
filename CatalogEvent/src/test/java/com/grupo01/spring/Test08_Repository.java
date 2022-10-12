package com.grupo01.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.grupo01.spring.repository.EventRepo;

///////////////// TEST OK ////////////////////
@DataMongoTest
public class Test08_Repository{
	
	@Autowired
	private EventRepo repo;
	
	@Test
	void contextLoads() {
		assertThat(repo).isNotNull();
	}

}