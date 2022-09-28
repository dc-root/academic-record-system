package main.operacoes;

import main.ficharios.FicharioAluno;
import main.modelos.Aluno;

import java.util.Scanner;
import java.util.ArrayList;

public class OpAluno {
    public void operacaoAluno(ArrayList<Aluno> alunos) {
        Scanner entrada = new Scanner(System.in);
        FicharioAluno fichario = new FicharioAluno(alunos);
        
        int opcao;
        do {
            System.out.print("\n 1. cadastrar aluno \n"+
                                "2. alterar aluno \n"+
                                "3. remover aluno \n"+
                                "4. consultar aluno \n"+
                                "5. relatorio de alunos \n"+
                                "0. sair \n\n"+
                                "opao: ");

            opcao = entrada.nextInt();

            switch(opcao) {
                case 1 -> fichario.cadastrarAluno();
                case 2 -> fichario.alterarAluno();
                case 3 -> fichario.removerAluno();
                case 4 -> fichario.consultarAluno();
                case 5 -> fichario.relatorioDeAlunos();
                default -> {
                    if(opcao != 0 ) System.out.println("Opção invalida!");
                }
            }
        } while(opcao != 0);
    }
}