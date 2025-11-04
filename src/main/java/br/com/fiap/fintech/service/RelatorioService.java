package br.com.fiap.fintech.service;

import br.com.fiap.fintech.repository.ReceitaRepository;
import br.com.fiap.fintech.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RelatorioService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private DespesaRepository despesaRepository;

    /**
     * Calcula o saldo e os totais de receitas e despesas para um usuário no mês.
     */
    public Map<String, Double> calcularSaldoMensal(Long usuarioId, int ano, int mes) {

        // Soma as receitas do mês e ano, com fallback para 0.0
        double totalReceita = receitaRepository
                .somarReceitasPorMes(usuarioId, ano, mes)
                .orElse(0.0);

        // Soma as despesas do mês e ano, com fallback para 0.0
        double totalDespesa = despesaRepository
                .somarDespesasPorMes(usuarioId, ano, mes)
                .orElse(0.0);

        double saldo = totalReceita - totalDespesa;

        Map<String, Double> relatorio = new HashMap<>();
        relatorio.put("totalReceita", totalReceita);
        relatorio.put("totalDespesa", totalDespesa);
        relatorio.put("saldoMensal", saldo);

        return relatorio;
    }
}