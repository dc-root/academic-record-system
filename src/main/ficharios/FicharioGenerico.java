package main.ficharios;

import java.util.ArrayList;
import java.util.Scanner;

public class FicharioGenerico<E> {
        protected ArrayList<E> persons;
        public Scanner entrada;

        protected FicharioGenerico(ArrayList<E> persons) {
            this.persons = persons;
            this.entrada = new Scanner(System.in);
        }

        protected void cadastrar(E unknown) {
            try {
                if(persons.contains(unknown)) {
                System.out.println("> warning: Já existe esse cpf cadastrado no sistem!");
                return;
            }

                persons.add(unknown);
                System.out.println("\n> Success: cadastrado realizado com sucesso!");
            } catch (Exception e) {
                System.out.println("\n>Error: não foi possivel execultar operação!");
            }
        }

        protected void alterar(int index, E unknown) {
            try {
                if(persons.contains(unknown)) {
                    System.out.println("> warning: Já existe esse cpf cadastrado no sistem!");
                    return;
                }

                persons.set(index, unknown);
            } catch (Exception e) {
                System.out.println("\n>Error: não foi possivel execultar operação!");
            }
        }

        protected void excluir(E unknown) {
            try {
                if(persons.contains(unknown)) {
                    System.out.print("Você realmente deseja excluir? (yes/no): ");
                    String option = entrada.nextLine();

                    switch(option) {
                        case "y", "Y", "YES", "yes" -> {
                            if(persons.remove(unknown)) {
                                System.out.println("\n> Success: removido com sucesso!");
                            } else {
                                System.out.println("> warnin: houve algum erro ao realizar remoção!");
                                return;
                            }
                        }
                        case "n", "N", "NO", "no" -> { return; }
                        default -> {
                            System.out.println("\n> warning: opção invalida!");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("\n>Error: não foi possivel execultar operação!");
            }
        }

        public void relatorio() {
                System.out.println("\n[RELATÓRIO]");
                System.out.println("------------------------------------------");
                
                persons.stream()
                    .forEach(person -> {
                            System.out.println(person);
                    });

                System.out.println("------------------------------------------");
        }
}
