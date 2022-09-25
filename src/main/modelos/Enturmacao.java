package main.modelos;

import main.modelos.Aluno;
import main.modelos.Turma;
import main.modelos.Professor;

import java.time.*;
import java.time.format.*;

import java.util.ArrayList;
import java.util.Objects;

public class Enturmacao {
    private String codigo;
    private LocalDateTime dataEnturmacao;

    private Aluno aluno;
    private Turma turma;

    public Enturmacao(
        Aluno aluno,
        Turma turma
    ) {
        this.dataEnturmacao = LocalDateTime.now();
        this.aluno = aluno;
        this.turma = turma;
        this.codigo = ""+dataEnturmacao.format(DateTimeFormatter.ofPattern("ddMMyyyyHHmmss"));
    }

    public String getCodigo() {
        return codigo;
    }
    public String getDataEnturmacao() {
        return ""+dataEnturmacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    public Aluno getAluno() {
        return aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void vincularAlunoaTurma() {
        this.aluno.receberTurma(this.turma);
    }

    public String toString() {
        return this.aluno+" ---> "+this.turma;
    }
    public boolean equals(Object myObject) {
        if(this == myObject) return true;
        if(myObject == null || this.getClass() != myObject.getClass()) return false;

        Enturmacao enturmacao = (Enturmacao) myObject;
        return Objects.equals(aluno, enturmacao.aluno) &&
               Objects.equals(turma, enturmacao.turma);
    }
    public int hashCode() {
        return Objects.hash(aluno, turma);
    }
}