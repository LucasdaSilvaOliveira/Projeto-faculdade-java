package controllers;

import java.sql.SQLException;

import entity.Aluno;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import repository.AlunoRepository;

@Path("/alunos")
public class AlunoController {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response BuscarAlunos() {
        return Response.ok(new AlunoRepository().ObterAlunos()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response BuscarAluno(@PathParam("id") int id) {
        return Response.ok(new AlunoRepository().ObterAlunoPorId(id)).build();
    }

    @POST
    @Path("/criar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response CriarAluno(Aluno aluno) {
        new AlunoRepository().CadastrarAluno(aluno);
        return Response.status(Response.Status.CREATED).entity("Aluno criado com sucesso").build();
    }

    @PUT
    @Path("/atualizar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarAluno(@PathParam("id") int id, Aluno aluno) {
        try {
            boolean atualizado = new AlunoRepository().AtualizarAluno(id, aluno);

            if (atualizado) {
                return Response.status(Response.Status.OK).entity("Aluno atualizado com sucesso").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Aluno não encontrado").build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao atualizar aluno").build();
        }
    }
}