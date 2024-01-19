package br.com.cifresuasmusicas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public ResponseEntity<String> bemVindo() {
        return ResponseEntity.ok("Bem vindo a aplicação -> Cifre Suas Músicas");
    }

    @GetMapping("/access-denied")
    public ResponseEntity<String> semPermissao() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Sem permissão para acessar esta URL.");
    }
}
