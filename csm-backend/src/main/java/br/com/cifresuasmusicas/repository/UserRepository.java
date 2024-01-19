package br.com.cifresuasmusicas.repository;

import java.util.Optional;

import br.com.cifresuasmusicas.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

	Optional<UserModel> findByUsername(String username);

	Optional<UserModel> findByEmail(String email);
}