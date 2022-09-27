package main.modelos;

import java.util.Objects;

public class Aluno extends Pessoa {
    private String matricula;

    public Aluno(){}
    public Aluno(
        String nome,
        String cpf
    ) {
        this.nome = nome;
        this.matricula = cpf;
        this.cpf = cpf;
    }
    
    public String getMatricula() {
        return this.matricula;
    }

    public String toString() {
        return "| nome: "+this.nome+" matricula: "+this.matricula;
    }
    public boolean equals(Object myObject) {
        if(this == myObject) return true;
        if(myObject == null || this.getClass() != myObject.getClass()) return false;

        Aluno aluno = (Aluno) myObject;
        return Objects.equals(matricula, aluno.matricula);
    }
    public int hashCode() {
        return Objects.hash(matricula);
    }
}