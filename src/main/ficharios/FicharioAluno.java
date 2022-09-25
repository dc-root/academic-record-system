package main.ficharios;

import main.modelos.Aluno;

import java.util.Scanner;
import java.util.ArrayList;

public class FicharioAluno {
    private Scanner entrada;

    private ArrayList<Aluno> alunos;

    public FicharioAluno(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
        this.entrada = new Scanner(System.in);
    }
    
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void cadastrar() {
        String nome, telefone, cpf, email;

        System.out.println("\n ------------- CADASTRO ALUNO ------------- ");
        System.out.print("Nome: ");
        nome = entrada.nextLine();

        System.out.print("CPF: ");
        cpf = entrada.nextLine();

        System.out.print("E-mail: ");
        email = entrada.nextLine();
        
        System.out.print("Telefone: ");
        telefone = entrada.nextLine();
        
        Aluno aluno = new Aluno(nome, cpf, telefone, email);
        
        if (alunos.contains(aluno)) {
            System.out.println("\n> Error: Não foi possivel cadastrar o aluno");
            System.out.println("> warning: Já existe um aluno com esse número de cpf cadastrado no sistem");
        } else {
            alunos.add(aluno);
            System.out.println("\n> Success: Aluno cadastrado com sucesso!");
        }
    }

    public void alterar() {
        System.out.print("Numero da matricula do aluno: ");
        String matricula = entrada.nextLine();

        Aluno alunoaSerAlterado = this.alunos.stream()
            .filter(aluno -> aluno.getMatricula()
                .equals(matricula)
            ).findAny().orElse(null);

        if(alunoaSerAlterado != null) {
            System.out.printf("Nome: ");
            alunoaSerAlterado.setNome(entrada.nextLine());

            System.out.printf("Telefone: ");
            alunoaSerAlterado.setTelefone(entrada.nextLine());

            System.out.printf("Email: ");
            alunoaSerAlterado.setEmail(entrada.nextLine());

            System.out.printf("\n> Success: Dados do(a) aluno(a) %s, atualizado com sucesso!\n", alunoaSerAlterado.getNome());
        } else {
            System.out.println("> Error: Número de matricula não encontrado!");
        }
    }

    public void excluir() {
        System.out.print("Numero da matricula do aluno a ser excluido: ");
        String matricula = entrada.nextLine();

        Aluno alunoaSerExcluido = this.alunos.stream()
        .filter(aluno -> aluno.getMatricula()
            .equals(matricula)
        ).findAny().orElse(null);

        if(alunoaSerExcluido != null ) {
            if(alunoaSerExcluido.getTurma() == null) {
                System.out.print("Você realmente deseja excluir este aluno? (yes/no): ");
                String option = entrada.nextLine();

                switch(option) {
                    case "y", "Y", "YES", "yes" -> {
                        if(this.alunos.remove(alunoaSerExcluido)) {
                            System.out.println("\n> Success: aluno(a) removido com sucesso!");
                        } else {
                            System.out.println("> warnin: houve algum erro ao remover o aluno!");
                            return;
                        }
                    }
                    case "n", "N", "NO", "no" -> { return; }
                    default -> {
                        System.out.println("\n> Error: opção invalida!");
                    }
                }
            } else {
                System.out.println("\n> Error: Houve um erro ao remover o aluno!");
                System.out.println("\t> warning: Talvez você esteja tentando excluir um aluno matriculado em alguma turma,\n\tdesvincule-o da turma antes de excluí-lo!");
            }
        } else {
            System.out.println("\nError: Matricula não encontrada! :(");
        }
    }

    public void consultar() {
        System.out.print("Numero da matricula do aluno: ");
        String matricula = entrada.nextLine();

        Aluno alunoaSerConsultado = this.alunos.stream()
        .filter(aluno -> aluno.getMatricula()
            .equals(matricula)
        ).findAny().orElse(null);
        
        if(alunoaSerConsultado != null) {
            System.out.printf("\n[RELATÓRIO DO(A) ALUNO(A) %s]\n", alunoaSerConsultado.getNome().toUpperCase());
            System.out.println("------------------------------------------");
            System.out.printf("| Número de matricula: %s\n", alunoaSerConsultado.getMatricula());
            System.out.println("------------------------------------------");
            System.out.printf("| Telefone: %s\n", alunoaSerConsultado.getTelefone());
            System.out.println("------------------------------------------");
            System.out.printf("| E-mail: %s\n", alunoaSerConsultado.getEmail());
            System.out.println("------------------------------------------");
            System.out.printf("| Turma: %s\n", (alunoaSerConsultado.getTurma() != null ? alunoaSerConsultado.getTurma().getNome()+"/"+alunoaSerConsultado.getTurma().getCodigo() : ""));
            System.out.println("------------------------------------------");
        } else {
            System.out.println("\nError: Numero de matricula não encontrado! :(");
        }
    }

    public void relatorio() {
        System.out.println("\n[RELATÓRIO DE ALUNOS]");
        System.out.println("------------------------------------------");
        this.alunos.stream()
            .forEach(aluno -> {
                System.out.println(aluno);
                System.out.println("------------------------------------------");
        });
    }
}