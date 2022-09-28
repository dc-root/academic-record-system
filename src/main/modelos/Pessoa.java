package main.modelos;

public abstract class Pessoa {
    protected String nome;
    protected String cpf;

    public Pessoa(){}
    public Pessoa(
        String nome,
        String cpf
    ) {
        this.nome = nome;
        this.cpf = cpf;
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
}
