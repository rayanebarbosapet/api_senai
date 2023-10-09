package com.api_senai.api.entities;

import java.time.LocalDate;
import java.util.Date;

import lombok.Data;

@Data
public abstract class Pessoa {
    private String nome;
    private String cpf;
    private LocalDate dataDeNascimento;
    private String telefone;
    private String email;

}
