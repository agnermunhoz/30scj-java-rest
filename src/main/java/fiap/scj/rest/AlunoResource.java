package fiap.scj.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/aluno")
public class AlunoResource {
	
	private static List<Aluno> alunos = new ArrayList<Aluno>();
	static {
		alunos.add(new Aluno("Humberto", 123));
		alunos.add(new Aluno("Doisberto", 124));
		alunos.add(new Aluno("Tresberto", 125));
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Aluno> getAllAlunos() {
		return alunos;
	}
	
	@GET
	@Path("/{ra}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Aluno findAluno(@PathParam(value = "ra") Integer ra) {
		for (Aluno aluno : alunos) {
			if (aluno.getRa().equals(ra)) {
				return aluno;
			}
		}
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAluno (Aluno aluno) throws Exception {
		
		alunos.add(aluno);
		
		return Response.created(new URI("http://localhost:8080/rest/aluno/" + aluno.getRa())).build();
		
	}

}
