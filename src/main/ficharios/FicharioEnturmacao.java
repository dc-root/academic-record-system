package main.ficharios;

import main.modelos.Enturmacao;
import main.modelos.Aluno;
import main.modelos.Turma;
import main.modelos.Professor;

import java.util.Scanner;
import java.util.ArrayList;

public class FicharioEnturmacao {
    private Scanner entrada;

    private ArrayList<Enturmacao> enturmacoes;
    private ArrayList<Turma> turmas;
    private ArrayList<Aluno> alunos;
    private ArrayList<Professor> profs;

    public FicharioEnturmacao(
        ArrayList<Enturmacao> enturmacoes,
        ArrayList<Turma> turmas,
        ArrayList<Aluno> alunos,
        ArrayList<Professor> profs
    ) {
        this.enturmacoes = enturmacoes;
        this.turmas = turmas;
        this.alunos = alunos;
        this.profs = profs;
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
        
        Professor pessoa = new Professor(
            alunoaSerMatriculado.getNome(),
            alunoaSerMatriculado.getCpf(),
            alunoaSerMatriculado.getTelefone(),
            alunoaSerMatriculado.getEmail()
        );

        if (this.profs.contains(pessoa)) {
            System.out.println("\n> Error: Não foi possivel matricular aluno");
            System.out.println("> warning: Essa pessoa já está cadastrada como professor nessa turma!");
            return;
        } else if((alunoaSerMatriculado != null) && (turmaaSeMatricular != null)) {
            if(turmaaSeMatricular.getAlunos().contains(alunoaSerMatriculado)) {
                System.out.println("\n> warning: Aluno(a) já está mtriculado(a) nessa turma!");
                return;
            } else if(alunoaSerMatriculado.getTurma() != null) {
                System.out.println("\n> warning: Este aluno(a) já está matriculado(a) na turma "+alunoaSerMatriculado.getTurma().getNome());
                return;
            } else {
                alunoaSerMatriculado.receberTurma(turmaaSeMatricular);
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

        Aluno alunoaSerMatriculado = this.alunos.stream()
            .filter(aluno -> aluno.getMatricula()
                .equals(matricula)
            ).findAny().orElse(null);

        Turma turmaaSeMatricular = this.turmas.stream()
        .filter(turma -> turma.getCodigo()
            .equals(codigo)
        ).findAny().orElse(null);

        if((alunoaSerMatriculado != null) && (turmaaSeMatricular != null)) {
            if(turmaaSeMatricular.getAlunos().contains(alunoaSerMatriculado)) {
                turmaaSeMatricular.getAlunos().remove(alunoaSerMatriculado);
                alunoaSerMatriculado.setTurma(null);
                System.out.println("\n> Sucess: Aluno(a) "+alunoaSerMatriculado.getNome()+" foi desmatriculado(a) com sucesso da turma "+turmaaSeMatricular.getNome());
            } else {
                System.out.println("\n> Warning: Este aluno não consta na lista de matriculados da turma!");
            }
        } else {
            System.out.println("\n> Error: Numero de matricula e/ou código da turma não encontrado!");
        }
    }
    
    // Profs
    public void vincularATurma() {
        System.out.print("Número do registro do professor: ");
        String registro = entrada.nextLine();

        System.out.print("Número do código da turma: ");
        String codigo = entrada.nextLine();

        Professor professoraSerVinculado = this.profs.stream()
            .filter(prof -> prof.getRegistro()
                .equals(registro)
            ).findAny().orElse(null);

        Turma turmaaSeVincular = this.turmas.stream()
            .filter(turma -> turma.getCodigo()
                .equals(codigo)
            ).findAny().orElse(null);

        Aluno pessoa = new Aluno(
            professoraSerVinculado.getNome(),
            professoraSerVinculado.getCpf(),
            professoraSerVinculado.getTelefone(),
            professoraSerVinculado.getEmail()
        );
        
        if(this.alunos.contains(pessoa)) {
            System.out.println("\n> Error: Não foi possivel vincular professor a turma");
            System.out.println("> warning: Essa pessoa já está cadastrada como aluno nessa turma!");
            return;
        } else if(professoraSerVinculado != null && turmaaSeVincular != null) {
            if(turmaaSeVincular.getProfs().contains(professoraSerVinculado)) {
                System.out.println("\n> Error: Não foi possivel vincular professor a turma");
                System.out.println("\n> Warning: Este professor já está vinculado a essa turma!");
                return;
            }
            professoraSerVinculado.receberTurma(turmaaSeVincular);
            
            System.out.println("\n> Sucess:  professor vinculado a turma "+turmaaSeVincular.getNome()+" com suceso!");
        } else {
            System.out.println("\n> Error: Número de registro e/ou código da turma não encontrado!");
        }
    }
    public void desvincularDeTurma() {
        System.out.print("Número do registro do professor: ");
        String registro = entrada.nextLine();

        System.out.print("Numero do código da turma: ");
        String codigo = entrada.nextLine();
        
        Professor professoraSerDesvinculado = this.profs.stream()
            .filter(prof -> prof.getRegistro()
                .equals(registro)
            ).findAny().orElse(null);

        Turma turmaaSeDesvincular = this.turmas.stream()
        .filter(turma -> turma.getCodigo()
            .equals(codigo)
        ).findAny().orElse(null);
        
        if(professoraSerDesvinculado != null && turmaaSeDesvincular != null) {
            if(turmaaSeDesvincular.getProfs().contains(professoraSerDesvinculado)) {
                turmaaSeDesvincular.getProfs().remove(professoraSerDesvinculado);
                professoraSerDesvinculado.getTurmas().remove(turmaaSeDesvincular);
                System.out.println("\n> Sucess: Professor "+professoraSerDesvinculado.getNome()+" desvinculado com sucesso da turma "+turmaaSeDesvincular.getNome());
            } else {
                System.out.println("\n> Warning: Este professor não consta na lista de matriculados da turma!");
            }
        } else {
            System.out.println("\n> Error: Número de registro e/ou código da turma não encontrado!");
        }
    }
}