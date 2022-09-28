import main.modelos.*;
import main.ficharios.*;
import main.operacoes.*;

import java.util.ArrayList;

public class Main {
        public static void main(String[] args) {
                ArrayList<Aluno> alunos = new ArrayList<>();
                // ArrayList<Turma> turmas = new ArrayList<>();
                
                // instanciar operacões
                OpAluno o = new OpAluno();
                // OpTurma o = new OpTurma();

                // TODO: menu de opções:
                o.operacaoAluno(alunos);
                // o.operacaoTurma(turmas);
        }
}
