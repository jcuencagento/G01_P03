package com.grupo01.spring;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.grupo01.spring.model.Usuario;
import com.grupo01.spring.repository.UsuarioRepository;


//////////////// Test NOT OK ///////////////
@DataJpaTest
public class Test06_SaveDeleteJpa {
    @Autowired
    private UsuarioRepository repo;

   @Test
    void contextLoads() {
        Usuario u = new Usuario();
        assertThat(repo.save(u).getMail()).isNull();

        Usuario uOK = new Usuario((long) 15, "javi", "hi", "javi@", "hola", null);
        uOK.setFechaActual(new Date());
        assertThat(repo.save(uOK).getMail()).isEqualTo(uOK.getMail());
    }

}
