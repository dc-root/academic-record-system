package main.modelos;

import java.util.Objects;
import java.time.*;
import java.time.format.*;

public class Aluno extends Pessoa {
    private String matricula;
    private Turma turma;

    public Aluno(){}
    public Aluno(
        String nome,
        String cpf,
        String telefone,
        String email,
        LocalDate dataNascimento
    ) {
        this.nome = nome;
        this.matricula = cpf;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }
    
    public String getMatricula() {
        return this.matricula;
    }
    public Turma getTurma() {
        return this.turma;
    }
    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    public String getDataNascimento() {
        return ""+this.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    protected void receberTurma(Turma turma) {
        this.turma = turma;
        turma.receberAluno(this);
    }

    public String toString() {
        return "| nome: "+this.nome+" matricula: "+this.matricula+" nascimento: "+this.getDataNascimento();
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