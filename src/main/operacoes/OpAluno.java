package main.operacoes;

import main.modelos.Aluno;

import main.ficharios.FicharioAluno;

import java.util.Scanner;
import java.util.ArrayList;

public class OpAluno {
    public static void operacaoAluno(ArrayList<Aluno> alunos) {
        Scanner entrada = new Scanner(System.in);
        FicharioAluno ficharioAluno = new FicharioAluno(alunos);
        int opcao;
        do {
            System.out.println("\n ##### ALUNO ##### ");
            System.out.println("1 - Cadastrar Aluno ");
            System.out.println("2 - Alterar Aluno ");
            System.out.println("3 - Excluir Aluno ");
            System.out.println("4 - Consultar Aluno ");
            System.out.println("5 - Relatório do Aluno ");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1 -> ficharioAluno.cadastrar();
                case 2 -> ficharioAluno.alterar();
                case 3 -> ficharioAluno.excluir();
                case 4 -> ficharioAluno.consultar();
                case 5 -> ficharioAluno.relatorio();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }
}