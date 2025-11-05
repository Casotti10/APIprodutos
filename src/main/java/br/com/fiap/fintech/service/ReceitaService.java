package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.Receita;
import br.com.fiap.fintech.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReceitaService {
    @Autowired
    private ReceitaRepository receitaRepository;

    public Receita salvar(Receita receita) {
        return receitaRepository.save(receita);
    }

    public List<Receita> listarTodos() {
        return receitaRepository.findAll();
    }

    public Receita buscarPorID(Long id) {
        return receitaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Receita com ID " + id + " não encontrada."));
    }

    public Receita atualizar(Long id, Receita receita) {
        if (!receitaRepository.existsById(id)) {
            throw new RuntimeException("Receita não encontrada.");
        }
        receita.setId(id);
        return receitaRepository.save(receita);
    }

    public void excluir(Long id) {
        if (!receitaRepository.existsById(id)) {
            throw new RuntimeException("Receita com ID " + id + " não encontrada.");
        }
        receitaRepository.deleteById(id);
    }
}