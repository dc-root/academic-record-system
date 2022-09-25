package main.modelos;

import java.util.Objects;
import java.util.ArrayList;

public class Professor extends Pessoa {
    private String registro;
    private String disciplina;

    public Professor(){}
    public Professor(
        String nome,
        String cpf,
        String telefone,
        String email,
        String disciplina
    ) {
        this.nome = nome;
        this.registro = cpf;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.disciplina = disciplina;
    }
    public String getRegistro() {
        return registro;
    }
    public String getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String toString() {
        return "| "+this.nome+" | "+this.registro+" | "+this.disciplina;
    }
    public boolean equals(Object myObject) {
        if(this == myObject) return true;
        if(myObject == null || this.getClass() != myObject.getClass()) return false;

        Professor professor = (Professor) myObject;
        return Objects.equals(registro, professor.registro);
    }
    public int hasCode() {
        return Objects.hash(registro);
    }
}
