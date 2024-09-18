package controllers;

import java.util.ArrayList;
import java.util.List;

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
       // Cria uma lista de alunos
        List<Aluno> alunos = new ArrayList<>();

        // Mocka um aluno para teste
        Aluno aluno = new Aluno();
        aluno.setId(1);
        aluno.setNome("Luck");
        aluno.setIdade(30);
        aluno.setDiaPagamento(7);

        // Adiciona o aluno mockado à lista
        alunos.add(aluno);

        // Retorna a lista mockada
        return alunos;
    }

}
