package controllers;

import jakarta.ws.rs.GET;
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

        // return new AlunoRepository().ObterAlunos();
        return Response.ok(new AlunoRepository().ObterAlunos()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response BuscarAluno(@PathParam("id") int id) {
        return Response.ok(new AlunoRepository().ObterAlunoPorId(id)).build();
    }
}
