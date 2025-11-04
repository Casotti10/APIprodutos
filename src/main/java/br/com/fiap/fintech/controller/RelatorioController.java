package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    // GET /api/relatorio/saldo/{usuarioId}?ano=2025&mes=11
    @GetMapping("/relatorio/saldo/{usuarioId}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Double> getSaldoMensal(
            @PathVariable Long usuarioId,
            @RequestParam int ano,
            @RequestParam int mes) {

        return relatorioService.calcularSaldoMensal(usuarioId, ano, mes);
    }
}