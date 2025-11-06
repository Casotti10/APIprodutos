package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.Receita;
import br.com.fiap.fintech.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api") // Prefixo da base da URL
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    // POST /api/receita
    @PostMapping("/receitas")
    @ResponseStatus(HttpStatus.CREATED)
    public Receita salvar(@RequestBody Receita receita) {
        return receitaService.salvar(receita);
    }

    // GET /api/receita
    @GetMapping("/receitas")
    @ResponseStatus(HttpStatus.OK)
    public List<Receita> listarTodos() {
        return receitaService.listarTodos();
    }

    // GET /api/receitas/{id}
    @GetMapping("/receitas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Receita buscarPorId(@PathVariable Long id) {
        return receitaService.buscarPorID(id);
    }

    // PUT /api/receitas/{id}
    @PutMapping("/receitas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Receita atualizar(@PathVariable Long id, @RequestBody Receita receita) {
        return receitaService.atualizar(id, receita);
    }

    // DELETE /api/receitas/{id}
    @DeleteMapping("/receitas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        receitaService.excluir(id);
    }
}