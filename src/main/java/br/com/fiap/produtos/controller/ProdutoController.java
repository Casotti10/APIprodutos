package br.com.fiap.produtos.controller;

import br.com.fiap.produtos.model.Produto;
import br.com.fiap.produtos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //indica que e uma aplicação rest, responde a um crud
@RequestMapping("/api") //prefixo da base da URL
public class ProdutoController {


    @Autowired //injetando as dependencias
    private ProdutoService produtoService;

    @PostMapping ("/produtos")//Cadastrar produto
    @ResponseStatus(HttpStatus.CREATED)
    public Produto salvar (@RequestBody Produto produto){
        return produtoService.salvar(produto);
    }

    @GetMapping("/produtos")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> listarTodos(){
        return produtoService.listarTodos();
    }

    @GetMapping("/produtos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto buscarPorId (@PathVariable Long id){
        return produtoService.buscarPorID(id);
    }

    @DeleteMapping("/produtos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void excluir (@PathVariable Long id){
        produtoService.excluir(id);
    }

    @PutMapping("/produtos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto atualizar (@RequestBody Produto produto, @PathVariable Long id){
        return produtoService.atualizar(id, produto);
    }

}
