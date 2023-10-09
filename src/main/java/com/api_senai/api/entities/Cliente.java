package com.api_senai.api.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
@Table(name= "clientes")
public class Cliente {
    @Id
    private long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    @OneToOne
    private Endereco endereco;
    private String telefone;
    private String email;
    private String login;
    @Column(name="password")
    private String senha;

}
