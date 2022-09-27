import main.modelos.Aluno;
import main.ficharios.FicharioAluno;

import java.util.ArrayList;

public class Main {
        public static void main(String[] args) {
                ArrayList<Aluno> alunos = new ArrayList<>();
                FicharioAluno operacaoAluno = new FicharioAluno(alunos);

                operacaoAluno.cadastrarAluno();
                operacaoAluno.cadastrarAluno();

                operacaoAluno.relatorio();
        }
}
