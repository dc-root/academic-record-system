package main.ficharios;

import main.modelos.Enturmacao;
import main.modelos.Aluno;
import main.modelos.Turma;

import java.util.Scanner;
import java.util.ArrayList;

public class FicharioEnturmacao {
    private Scanner entrada;

    private ArrayList<Enturmacao> enturmacoes;
    private ArrayList<Turma> turmas;
    private ArrayList<Aluno> alunos;

    public FicharioEnturmacao(
        ArrayList<Enturmacao> enturmacoes,
        ArrayList<Turma> turmas,
        ArrayList<Aluno> alunos
    ) {
        this.enturmacoes = enturmacoes;
        this.turmas = turmas;
        this.alunos = alunos;
        this.entrada = new Scanner(System.in);
    }

    // Alunos
    public void matricularAluno() {
        System.out.print("Numero da matricula do aluno: ");
        String matricula = entrada.nextLine();

        System.out.print("Numero do código da turma: ");
        String codigo = entrada.nextLine();

        Aluno alunoaSerMatriculado = this.alunos.stream()
        .filter(aluno -> aluno.getMatricula()
            .equals(matricula)
        ).findAny().orElse(null);

        Turma turmaaSeMatricular = this.turmas.stream()
        .filter(turma -> turma.getCodigo()
            .equals(codigo)
        ).findAny().orElse(null);


       if(alunoaSerMatriculado != null && turmaaSeMatricular != null) {
            Enturmacao novaEnturmacao = new Enturmacao(alunoaSerMatriculado, turmaaSeMatricular);

            if(turmaaSeMatricular.getAlunos().contains(alunoaSerMatriculado) || enturmacoes.contains(novaEnturmacao)) {
                System.out.println("\n> warning: Aluno(a) já está mtriculado(a) nessa turma!");
                return;
            } else if(alunoaSerMatriculado.getTurma() != null || enturmacoes.contains(novaEnturmacao)) {
                System.out.println("\n> warning: Este aluno(a) já está matriculado(a) na turma "+alunoaSerMatriculado.getTurma().getNome());
                return;
            } else {
                enturmacoes.add(novaEnturmacao);
                novaEnturmacao.vincularAlunoaTurma();

                System.out.println("\n> Sucess: aluno(a) "+alunoaSerMatriculado.getNome()+" matriculado(a) com suceso na turma "+turmaaSeMatricular.getNome());
            }
        } else {
            System.out.println("\n> Error: Numero de matricula do aluno e/ou código da turma não encontrado!");
        }
    }
    public void desmatricularAluno() {
        System.out.print("Numero da matricula do aluno: ");
        String matricula = entrada.nextLine();

        System.out.print("Número do código da turma: ");
        String codigo = entrada.nextLine();

        Aluno alunoaSerDesmatriculado = this.alunos.stream()
        .filter(aluno -> aluno.getMatricula()
            .equals(matricula)
        ).findAny().orElse(null);

        Turma turmaaSeDesmatricular = this.turmas.stream()
        .filter(turma -> turma.getCodigo()
            .equals(codigo)
        ).findAny().orElse(null);

        if((alunoaSerDesmatriculado != null) || (turmaaSeDesmatricular != null)) {
            if(turmaaSeDesmatricular.getAlunos().contains(alunoaSerDesmatriculado)) {
                turmaaSeDesmatricular.getAlunos().remove(alunoaSerDesmatriculado);
                alunoaSerDesmatriculado.setTurma(null);

                enturmacoes.remove(this.enturmacoes.stream()
                    .filter(enturmacao -> enturmacao.getAluno()
                        .equals(alunoaSerDesmatriculado) && enturmacao.getTurma()
                        .equals(turmaaSeDesmatricular)
                    ).findAny().orElse(null)
                );

                System.out.println("\n> Sucess: Aluno(a) "+alunoaSerDesmatriculado.getNome()+" foi desmatriculado(a) com sucesso da turma "+turmaaSeDesmatricular.getNome());
            } else {
                System.out.println("\n> Warning: Este aluno não consta na lista de matriculados da turma!");
            }
        } else {
            System.out.println("\n> Error: Numero de matricula e/ou código da turma não encontrado!");
        }
    }

    // Professor
    public void matricularProfessoraTurma() {}
    public void desmatricularProfessorDeTurma() {}

    public void relatorio() {
        System.out.println("\n[RELATÓRIO DE ENTURMAÇÕES]");
        System.out.println("------------------------------------------");
        this.enturmacoes.stream()
            .forEach(enturmacao -> {
                System.out.println(enturmacao);
                System.out.println("------------------------------------------");
        });
    }
}