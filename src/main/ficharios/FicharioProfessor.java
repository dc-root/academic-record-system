package main.ficharios;

import main.modelos.Professor;

import java.util.Scanner;
import java.util.ArrayList;

public class FicharioProfessor {
    private Scanner entrada;

    private ArrayList<Professor> profs;

    public FicharioProfessor(ArrayList<Professor> profs) {
        this.profs = profs;
        this.entrada = new Scanner(System.in);
    }

    public void cadastrar() {
        String nome, telefone, cpf, email, disciplina;

        System.out.println("\n ------------- CADASTRO PROFESSOR ------------- ");
        System.out.print("Nome: ");
        nome = entrada.nextLine();

        System.out.print("CPF: ");
        cpf = entrada.nextLine();

        System.out.print("E-mail: ");
        email = entrada.nextLine();

        System.out.print("Telefone: ");
        telefone = entrada.nextLine();

        System.out.print("Disciplina: ");
        disciplina =  entrada.nextLine();

        Professor professor = new Professor(nome, cpf, telefone, email, disciplina);
        if (this.profs.contains(professor)) {
            System.out.println("\n> Error: Não foi possivel cadastrar o professor");
            System.out.println("> warning: Já existe um professor com algum dos dados cadastrado no sistem");
            return;
        } else {
            this.profs.add(professor);
            System.out.println("\n> Success: Professor cadastrado com sucesso!");
        }
    }

    public void alterar() {
        System.out.print("Número do registro: ");
        String registro = entrada.nextLine();
        
        Professor professoraSerAlterado = this.profs.stream()
            .filter(prof -> prof.getRegistro()
                .equals(registro)
            ).findAny().orElse(null);

        if(professoraSerAlterado != null) {
            System.out.printf("Nome: ");
            professoraSerAlterado.setNome(entrada.nextLine());

            System.out.printf("Telefone: ");
            professoraSerAlterado.setTelefone(entrada.nextLine());;

            System.out.printf("Email: ");
            professoraSerAlterado.setEmail(entrada.nextLine());

            System.out.printf("Disciplina: ");
            professoraSerAlterado.setDisciplina(entrada.nextLine());

            System.out.printf("\n> Success: Dados do(a) aluno(a) %s, atualizado com sucesso!\n", professoraSerAlterado.getNome());
        } else {
            System.out.println("> Error: Número de registro do professor não encontrado!");
        }
    }

    public void excluir() {
        System.out.print("Numero do registro: ");
        String registro = entrada.nextLine();

        Professor professoraSerRemovido = this.profs.stream()
        .filter(prof -> prof.getRegistro()
            .equals(registro)
        ).findAny().orElse(null);

        if(professoraSerRemovido != null) {
            // if(professoraSerRemovido.getTurmas().size() == 0) {
                System.out.print("Você realmente deseja excluir este professor? (yes/no): ");
                String option = entrada.nextLine();

                switch(option) {
                    case "y", "Y", "YES", "yes" ->  {
                        if(this.profs.remove(professoraSerRemovido)) {
                            System.out.println("\n> Success: professor(a) removido com sucesso!");
                        } else {
                            System.out.println("> warning: houve algum erro ao remover o professor!");
                        }
                    }
                    case "n", "N", "NO", "no" -> { return; }
                    default -> {
                        System.out.println("\n> Error: opção invalida!");
                    }
                }
            // } else {
            //     System.out.println("\n> Error: Houve um erro ao remover professor!");
            //     System.out.println("\t> warning: Talvez você esteja tentando excluir um professor matriculado em alguma turma,\n\tdesvincule-o da turma antes de excluí-lo!");
            // }
        }  else {
            System.out.println("\nError: Registro não encontrado! :(");
        }
    }

    public void consultar() {
        System.out.print("\nNumero do registro: ");
        String registro = entrada.nextLine();

        Professor professoraSerConsultado = this.profs.stream()
        .filter(prof -> prof.getRegistro()
            .equals(registro)
        ).findAny().orElse(null);
        
        if(professoraSerConsultado != null) {
            System.out.printf("\n[RELATÓRIO DO(A) PROFESSOR(A) %s]\n", professoraSerConsultado.getNome().toUpperCase());
            System.out.println("------------------------------------------");
            System.out.printf("| Número de registro: %s\n", professoraSerConsultado.getRegistro());
            System.out.println("------------------------------------------");
            System.out.printf("| Telefone: %s\n", professoraSerConsultado.getTelefone());
            System.out.println("------------------------------------------");
            System.out.printf("| E-mail: %s\n", professoraSerConsultado.getEmail());
            System.out.println("------------------------------------------");
            System.out.printf("| Disciplina: %s\n", professoraSerConsultado.getDisciplina());
            System.out.println("------------------------------------------");
        } else {
            System.out.println("\nError: Numero de registro não encontrado! :(");
        }
    }

    public void relatorio() {
        System.out.println("\n[RELATÓRIO DE PROFESSORES]");
        System.out.println("---------------------");
        this.profs.stream().forEach(prof -> {
            System.out.println(prof);
            System.out.println("---------------------");
        });
    }
}