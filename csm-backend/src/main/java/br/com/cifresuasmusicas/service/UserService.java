package br.com.cifresuasmusicas.service;

import java.util.List;
import java.util.Optional;

import br.com.cifresuasmusicas.model.UserModel;
import br.com.cifresuasmusicas.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;

	public List<UserModel> findAll() {
		return userRepository.findAll();
	}

	public Optional<UserModel> findById(Long id) {
		return userRepository.findById(id);
	}

	public Optional<UserModel> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public Optional<UserModel> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}