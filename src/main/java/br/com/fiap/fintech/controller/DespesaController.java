package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.model.Despesa;
import br.com.fiap.fintech.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api") // Prefixo da base da URL
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    // POST /api/despesa
    @PostMapping("/despesas")
    @ResponseStatus(HttpStatus.CREATED)
    public Despesa salvar(@RequestBody Despesa despesa) {
        return despesaService.salvar(despesa);
    }

    // GET /api/despesa
    @GetMapping("/despesas")
    @ResponseStatus(HttpStatus.OK)
    public List<Despesa> listarTodos() {
        return despesaService.listarTodos();
    }

    // GET /api/despesas/{id}
    @GetMapping("/despesas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Despesa buscarPorId(@PathVariable Long id) {
        return despesaService.buscarPorID(id);
    }

    // PUT /api/despesas/{id}
    @PutMapping("/despesas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Despesa atualizar(@PathVariable Long id, @RequestBody Despesa despesa) {
        return despesaService.atualizar(id, despesa);
    }

    // DELETE /api/despesas/{id}
    @DeleteMapping("/despesas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        despesaService.excluir(id);
    }
}