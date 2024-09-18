import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import entity.Aluno;
import repository.AlunoRepository;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Aluno aluno = new Aluno();
        aluno.setNome("Lucas da Silva");
        aluno.setIdade(26);
        aluno.setDiaPagamento(10);

        new AlunoRepository().CadastrarAluno(aluno);
    }
}
