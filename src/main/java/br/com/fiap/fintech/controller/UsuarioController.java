package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // POST /api/usuario
    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }

    // GET /api/usuario
    @GetMapping("/usuario")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    // GET /api/usuarios/{id}
    @GetMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorID(id);
    }

    // DELETE /api/usuarios/{id}
    @DeleteMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        usuarioService.excluir(id);
    }

    // PUT /api/usuarios/{id}
    @PutMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario atualizar(@RequestBody Usuario usuario, @PathVariable Long id) {
        return usuarioService.atualizar(id, usuario);
    }
}