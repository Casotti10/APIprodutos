package br.com.fiap.fintech.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_despesa")
public class Despesa {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "despesa_seq"
    )
    @SequenceGenerator(
            name = "despesa_seq",
            sequenceName = "SEQ_DESPESAS",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false)
    private double valor;

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

    public LocalDate getDataDespesa() {
        return dataDespesa;
    }

    public void setDataDespesa(LocalDate dataDespesa) {
        this.dataDespesa = dataDespesa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Column(length = 100, nullable = false)
    private String descricao;

    @Column(name = "data_despesa", nullable = false)
    private LocalDate dataDespesa;

    // Relacionamento: Muitas Despesas para Um Usuário
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Construtor vazio obrigatório para o JPA
    public Despesa() {}

    // ... Getters e Setters para todos os campos (incluindo o Usuario)
}