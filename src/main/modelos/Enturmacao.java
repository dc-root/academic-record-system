package main.modelos;

import main.modelos.Aluno;
import main.modelos.Turma;
import main.modelos.Professor;

import java.util.Random;
import java.util.ArrayList;
import java.util.Objects;

public class Enturmacao {
    private String codigo;
    private Aluno aluno;
    private Turma turma;

    private Random gerador = new Random();

    public Enturmacao(
        Aluno aluno,
        Turma turma
    ) {
        this.codigo = ""+gerador.nextInt(100000);
        this.aluno = aluno;
        this.turma = turma;
    }

    public String getCodigo() {
        return codigo;
    }

    public String toString() {
        return this.aluno+" ---> "+this.turma;
    }
    public boolean equals(Object myObject) {
        if(this == myObject) return true;
        if(myObject == null || this.getClass() != myObject.getClass()) return false;

        Enturmacao enturmacao = (Enturmacao) myObject;
        return Objects.equals(codigo, enturmacao.codigo);
    }
    public int hashCode() {
        return Objects.hash(codigo);
    }
}