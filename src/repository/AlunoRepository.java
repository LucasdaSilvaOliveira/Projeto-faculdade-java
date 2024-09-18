package repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.Aluno;

public class AlunoRepository {
    
    public void CadastrarAluno(Aluno aluno) {
        String sql = "INSERT INTO Alunos (Nome, Idade, DiaPagamento) VALUES (? ,? ,?)";

        PreparedStatement ps = null;
        
        try {
            ps = Conexao.GetConnection().prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setInt(2, aluno.getIdade());
            ps.setInt(3, aluno.getDiaPagamento());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
