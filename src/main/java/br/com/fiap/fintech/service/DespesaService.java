package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.Despesa;
import br.com.fiap.fintech.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DespesaService {
    @Autowired
    private DespesaRepository despesaRepository;

    public Despesa salvar(Despesa despesa) {
        return despesaRepository.save(despesa);
    }

    public List<Despesa> listarTodos() {
        return despesaRepository.findAll();
    }

    public Despesa buscarPorID(Long id) {
        return despesaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Despesa com ID " + id + " não encontrada."));
    }

    public Despesa atualizar(Long id, Despesa despesa) {
        if (!despesaRepository.existsById(id)) {
            throw new RuntimeException("Despesa não encontrada.");
        }
        despesa.setId(id);
        return despesaRepository.save(despesa);
    }

    public void excluir(Long id) {
        if (!despesaRepository.existsById(id)) {
            throw new RuntimeException("Despesa com ID " + id + " não encontrada.");
        }
        despesaRepository.deleteById(id);
    }
}