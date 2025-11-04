package br.com.fiap.fintech.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity // Mapeia a classe para uma entidade JPA
@Table (name = "tb_usuario") // Define o nome da tabela no banco de dados (ex: tb_usuario)
public class Usuario {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "usuario_seq"
    )
    @SequenceGenerator(
            name = "usuario_seq",
            sequenceName = "SEQ_USUARIOS", // Nome da sequência no Oracle (adapte se for diferente)
            allocationSize = 1
    )
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 150, nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String senha;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    // ================== Getters e Setters ==================

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}