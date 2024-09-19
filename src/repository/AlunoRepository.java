package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import conexao.Conexao;
import entity.Aluno;

public class AlunoRepository {

    public List<Aluno> ObterAlunos() {
        List<Aluno> alunos = new ArrayList<Aluno>();

        String sql = "SELECT * FROM Alunos";

        PreparedStatement ps = null;
        
        try {

            ps = Conexao.GetConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setDiaPagamento(rs.getInt("diaPagamento"));
                
                alunos.add(aluno);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return alunos;
    }

    public Aluno ObterAlunoPorId(int id) {
        Aluno aluno = new Aluno();
        String sql = "SELECT * FROM Alunos WHERE id = ?";
        PreparedStatement ps = null;

        try {
            ps = Conexao.GetConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            rs.next();

            aluno.setId(id);
            aluno.setNome(rs.getString("nome"));
            aluno.setIdade(rs.getInt("idade"));
            aluno.setDiaPagamento(rs.getInt("diaPagamento"));

            return aluno;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public void CadastrarAluno(Aluno aluno) {
        String sql = "INSERT INTO Alunos (nome, idade, diaPagamento) VALUES (? ,? ,?)";

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

    public boolean AtualizarAluno(int id, Aluno aluno) throws SQLException {
        String sql = "UPDATE Alunos SET nome = ?, idade = ?, diaPagamento = ? WHERE Id = ?";

        PreparedStatement ps = null;

        ps = Conexao.GetConnection().prepareStatement(sql);
        
        ps.setString(1, aluno.getNome());
        ps.setInt(2, aluno.getIdade());
        ps.setInt(3, aluno.getDiaPagamento());
        ps.setInt(4, id);

        int linhasAfetadas = ps.executeUpdate();
        return linhasAfetadas > 0; 
    }

    public boolean deletarAlunoPorId(int id) {
        String sql = "DELETE FROM Alunos WHERE Id = ?";
        PreparedStatement ps = null;
        try {
            ps = Conexao.GetConnection().prepareStatement(sql);
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();
            
            return affectedRows > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
