package main.operacoes;

import main.modelos.Professor;

import main.ficharios.FicharioProfessor;
import main.ficharios.FicharioEnturmacao;

import java.util.Scanner;
import java.util.ArrayList;

public class OpProfessor {
    public static void operacaoProfessor(
        ArrayList<Professor> profs,
        FicharioEnturmacao ficharioEnturmacao
    ) {
        Scanner entrada = new Scanner(System.in);
        FicharioProfessor ficharioProfessor = new FicharioProfessor(profs);
        int opcao;
        do {
            System.out.println("\n ##### PROFESSOR ##### ");
            System.out.println("1 - Cadastrar Professor ");
            System.out.println("2 - Alterar Professor ");
            System.out.println("3 - Excluir Professor ");
            System.out.println("4 - Consultar Professor ");
            System.out.println("5 - Relatório do Professor ");
            // System.out.println("6 - Matricular professor em uma turma ");
            // System.out.println("7 - Desmatricular professor de uma turma ");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1 -> ficharioProfessor.cadastrar();
                case 2 -> ficharioProfessor.alterar();
                case 3 -> ficharioProfessor.excluir();
                case 4 -> ficharioProfessor.consultar();
                case 5 -> ficharioProfessor.relatorio();
                // case 6 -> ficharioEnturmacao.matricularProfessoraTurma();
                // case 7 -> ficharioEnturmacao.desmatricularProfessorDeTurma();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }
}
