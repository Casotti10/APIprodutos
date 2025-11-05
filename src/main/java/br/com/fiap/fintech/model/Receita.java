package br.com.fiap.fintech.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_receita")
public class Receita {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "receita_seq"
    )
    @SequenceGenerator(
            name = "receita_seq",
            sequenceName = "SEQ_RECEITAS",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false)
    private double valor;

    @Column(length = 100, nullable = false)
    private String descricao;

    @Column(name = "data_receita", nullable = false)
    private LocalDate dataReceita;

    // Relacionamento: Muitas Receitas para Um Usuário
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Construtor vazio obrigatório para o JPA
    public Receita() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataReceita() {
        return dataReceita;
    }

    public void setDataReceita(LocalDate dataReceita) {
        this.dataReceita = dataReceita;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}