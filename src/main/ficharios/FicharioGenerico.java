package main.ficharios;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class FicharioGenerico<E> {
        protected ArrayList<E> persons;
        private Scanner entrada;

        protected FicharioGenerico(ArrayList<E> persons) {
            this.persons = persons;
            this.entrada = new Scanner(System.in);
        }

        protected void cadastrar(E unknown) {
            try {
                if(persons.contains(unknown)) {
                    System.out.println("\n> warning: Já existe esse cpf cadastrado no sistem!");
                    return;
                }

                persons.add(unknown);
                System.out.println("\n> Success: cadastrado realizado com sucesso!");
            } catch (Exception e) {
                System.out.println("\n>Error: não foi possivel execultar: 'cadastrar()'");
            }
        }

        protected void alterar(int index, E unknown) {
            try {
                persons.set(index, unknown);
                System.out.println("\nAlteração realizada com sucesso!");
            } catch (Exception e) {
                System.out.println("\n>Error: não foi possivel execultar: 'alterar()' ");
            }
        }

        protected void remover(E unknown) {
            try {
                System.out.print("Você realmente deseja excluir? (yes/no): ");
                String option = entrada.nextLine();

                switch(option) {
                    case "y", "Y", "YES", "yes" -> {
                        if(persons.remove(unknown)) {
                            System.out.println("\n> Success: removido com sucesso!");
                        } else {
                            System.out.println("\n> warnin: houve algum erro ao realizar remoção!");
                            return;
                        }
                    }
                    case "n", "N", "NO", "no" -> { return; }
                    default -> {
                        System.out.println("\n> warning: opção invalida!");
                    }
                }
            } catch (Exception e) {
                System.out.println("\n>Error: não foi possivel execultar: 'remover()'");
            }
        }
}
