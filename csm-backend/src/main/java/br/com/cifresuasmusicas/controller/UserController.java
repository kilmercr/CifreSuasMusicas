package br.com.cifresuasmusicas.controller;

import java.util.Collection;
import java.util.Optional;

import br.com.cifresuasmusicas.model.UserModel;
import br.com.cifresuasmusicas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MODERATOR')")
    @GetMapping
    public ResponseEntity<Collection<UserModel>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
        Optional<UserModel> optUM = userService.findById(id);
        if (optUM.isPresent())
            return ResponseEntity.ok(optUM.get());
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário com o id [ " + id + " ] não encontrado!");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/name/{username}")
    public ResponseEntity<Object> findByUsername(@PathVariable(name = "username") String username) {
        Optional<UserModel> optUM = userService.findByUsername(username);
        if (optUM.isPresent())
            return ResponseEntity.ok(optUM.get());
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Usuário com o username [ " + username + " ] não encontrado!");
    }
}