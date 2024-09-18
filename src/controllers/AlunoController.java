package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entity.Aluno;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/alunos")
public class AlunoController {

    @GET
    @Path("/BuscarAlunos")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Aluno> BuscarAlunos() {

        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM Alunos";
        
        try (Connection conn = Conexao.GetConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("Id"));
                aluno.setNome(rs.getString("Nome"));
                aluno.setIdade(rs.getInt("Idade"));
                aluno.setDiaPagamento(rs.getInt("DiaPagamento"));
                
                alunos.add(aluno);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return alunos;
    }
}
