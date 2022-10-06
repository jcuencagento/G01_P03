package com.grupo01.spring;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.grupo01.spring.repository.UsuarioRepository;

@DataJpaTest
public class Test05_JpaRepo {
	@Autowired
	private UsuarioRepository repo;

	@Test
	void contextLoads() {
		assertThat(repo).isNotNull();
	}
}
