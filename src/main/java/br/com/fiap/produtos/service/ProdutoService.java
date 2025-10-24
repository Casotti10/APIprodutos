package br.com.fiap.produtos.service;

import br.com.fiap.produtos.model.Produto;
import br.com.fiap.produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// A anotação @Service indica que essa classe faz parte da camada de serviço.
// É onde fica a lógica de negócio da aplicação.
@Service
public class ProdutoService {

    // Injeta automaticamente uma instância de ProdutoRepository para acessar o BD
    @Autowired
    private ProdutoRepository produtoRepository;

    // metodo para salvar um produto no banco de dados.
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    // metodo para buscar um produto pelo ID.
    public Produto buscarPorID(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id); // O metodo findById retorna um Optional (pode ter ou não um produto).
        if (produto.isPresent()) {    // Se o produto existir, retorna o produto encontrado.
            return produto.get();
        } else {                      // Se não existir, lança uma exceção.
            throw new RuntimeException("Produto com ID " + id + " não encontrado.");
        }
    }


    // metodo para atualizar um produto existente.
    public Produto atualizar(Long id, Produto produto) {
        Optional<Produto> produtoAtual = produtoRepository.findById(id);
        if(produtoAtual.isPresent()){
            return produtoRepository.save(produto);
        }else{
            throw new RuntimeException("Produto não encontrado.");
        }

    }

    // metodo para buscar todos os produtos.
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public void excluir(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            produtoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Produto com ID " + id + " não encontrado.");
        }
    }

}