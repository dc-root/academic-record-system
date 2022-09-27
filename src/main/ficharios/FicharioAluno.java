package main.ficharios;

import main.modelos.Aluno;
import java.util.ArrayList;

public class FicharioAluno extends FicharioGenerico<Aluno> {
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
                System.out.print("Posição do aluno na lista: ");
                int index = entrada.nextInt();

                Aluno alunoaSerAlterado = persons.get(index);

                System.out.printf("Nome: ");
                alunoaSerAlterado.setNome(entrada.nextLine());

                System.out.printf("\n> Success: Dados do(a) aluno(a) %s, atualizado com sucesso!\n", alunoaSerAlterado.getNome());
        }
}
