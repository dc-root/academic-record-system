package main.ficharios;

import main.modelos.Aluno;

import java.util.ArrayList;
import java.util.Scanner;

public class FicharioAluno extends FicharioGenerico<Aluno> {
        private Scanner entrada = new Scanner(System.in);

        public FicharioAluno(ArrayList<Aluno> alunos) {
                super(alunos);
        }

        public void cadastrarAluno() {
                String nome, cpf;

                System.out.println("\n ------------- CADASTRO ALUNO ------------- ");
                System.out.print("Nome: ");
                nome = entrada.nextLine();

                System.out.print("CPF: ");
                cpf = entrada.nextLine();
                
                Aluno aluno = new Aluno(nome, cpf);

                cadastrar(aluno);
        }

        public void alterarAluno() {
                System.out.print("Digite o numero da matricula do aluno: ");
                String matricula = entrada.nextLine();

                Aluno alunoaSerAlterado = buscarAluno(matricula);
                
                if(alunoaSerAlterado != null) {
                        int index = persons.indexOf(alunoaSerAlterado);

                        System.out.printf("Nome: ");
                        alunoaSerAlterado.setNome(entrada.nextLine());

                        alterar(index, alunoaSerAlterado);
                } else {
                        System.out.println("\n> warning: número de matricula não encontrado!");
                }
        }

        public void removerAluno() {
                System.out.print("Digite o numero da matricula do aluno: ");
                String matricula = entrada.nextLine();

                Aluno alunoaSerRemovido = buscarAluno(matricula);

                if(alunoaSerRemovido != null) {
                        if(persons.contains(alunoaSerRemovido)) {
                                remover(alunoaSerRemovido);
                        } else {
                                System.out.println("\n> warning: esse aluno já  não consta na lista de matriculados!");
                        }
                } else {
                        System.out.println("\n> warning: número de matricula não encontrado!");
                } 
        }

        public void consultarAluno() {
                System.out.print("Numero da matricula do aluno: ");
                String matricula = entrada.nextLine();

                Aluno alunoaSerConsultado = buscarAluno(matricula);

                if(alunoaSerConsultado != null) {
                        System.out.printf("\n[RELATÓRIO DO(A) ALUNO(A) %s]\n", alunoaSerConsultado.getNome().toUpperCase());
                        System.out.println("------------------------------------------");
                        System.out.printf("| Número de matricula: %s\n", alunoaSerConsultado.getMatricula());
                        System.out.println("------------------------------------------\ntelefone");
                        // System.out.printf("| Telefone: %s\n", alunoaSerConsultado.getTelefone());
                        System.out.println("------------------------------------------\nemail");
                        // System.out.printf("| E-mail: %s\n", alunoaSerConsultado.getEmail());
                        System.out.println("------------------------------------------\nturma");
                        // System.out.printf("| Turma: %s\n", (alunoaSerConsultado.getTurma() != null ? alunoaSerConsultado.getTurma().getNome()+"/"+alunoaSerConsultado.getTurma().getCodigo() : ""));
                        System.out.println("------------------------------------------");
                } else {
                        System.out.println("\n> warning: número de matricula não encontrado!");
                } 
        }

        private Aluno buscarAluno(String matricula) {
                Aluno alunoEncontrado = persons.stream()
                .filter(aluno -> aluno.getMatricula()
                        .equals(matricula)
                ).findAny().orElse(null);

                return alunoEncontrado;
        }

        public void relatorioDeAlunos() {
                System.out.println("\n[RELATÓRIO]");
                System.out.println("------------------------------------------");
                
                persons.stream()
                    .forEach(aluno -> {
                        System.out.println(aluno);
                    });

                System.out.println("------------------------------------------");
        }
}
