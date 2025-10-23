package br.com.fiap.produtos.model;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

@Entity //mapea Produto" para uma entidade no BD
@Table (name = "tb_produto") //cria uma tabela no banco
public class Produto {

    @Id //indica que o ID vai ser a chave primaria
    @GeneratedValue( //configuramos com o atributo sera gerado
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_PRODUTOS"
    )
    @SequenceGenerator( //configuramos com o atributo sera gerado
            name = "SEQ_PRODUTOS",
            sequenceName = "SEQ_PRODUTOS",
            allocationSize = 1
    )
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;
    private double valor;
    private int quantidade;

    @Column(name = "data_fabricacao")
    private LocalDate dataFabricacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }
}