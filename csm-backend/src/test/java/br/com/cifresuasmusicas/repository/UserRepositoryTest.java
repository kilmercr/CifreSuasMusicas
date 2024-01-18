package br.com.cifresuasmusicas.repository;

import br.com.cifresuasmusicas.model.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class UserRepositoryTest {

	@Autowired
	private UserRepository repository;

	private static String USERNAME_DO_MODERADOR = "moderator";
	private static String EMAIL_DO_USUARIO = "usuario@csm.com.br";

	private UserModel moderador;
	private UserModel usuario;

	@BeforeEach
	void setUp() {
		moderador = repository.findByUsername(USERNAME_DO_MODERADOR).orElse(null);
		usuario = repository.findByEmail(EMAIL_DO_USUARIO).orElse(null);
	}

	@Test
	void findByUsername() {
		assertNotNull(moderador);
		assertEquals(USERNAME_DO_MODERADOR, moderador.getUsername());
	}

	@Test
	void findByEmail() {
		assertNotNull(moderador);
		assertEquals(EMAIL_DO_USUARIO, usuario.getEmail());
	}
}