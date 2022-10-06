package com.grupo01.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDatabaseTest {
	
	@Test
	void contextLoads() {
		assertThat(true).isTrue();
	}

}
