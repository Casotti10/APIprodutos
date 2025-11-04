package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dto.LoginRequest;
import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // POST /api/login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        // 1. Busca o usuário no banco de dados pelo email
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(loginRequest.email());

        if (usuarioOpt.isEmpty()) {
            // Usuário não encontrado
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Email ou senha inválidos."));
        }

        Usuario usuario = usuarioOpt.get();

        // 2. Verifica a senha (SIMULAÇÃO: Senha em texto puro)
        if (usuario.getSenha().equals(loginRequest.senha())) {

            // Sucesso! Retorna o ID do usuário (necessário para as requisições de Receita/Despesa)
            return ResponseEntity.ok()
                    .body(Map.of(
                            "message", "Login bem-sucedido",
                            "usuarioId", usuario.getId(),
                            "usuarioNome", usuario.getNome()
                    ));
        } else {
            // Senha incorreta
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Email ou senha inválidos."));
        }
    }
}