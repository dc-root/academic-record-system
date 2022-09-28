package main.modelos;

import java.time.*;

public abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected String telefone;
    protected String email;
    protected LocalDate dataNascimento;

    public Pessoa(){}
    public Pessoa(
        String nome,
        String cpf,
        String telefone,
        String email
    ) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
