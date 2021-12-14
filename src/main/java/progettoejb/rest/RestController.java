package progettoejb.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import progettoejb.dto.AutoreDto;
import progettoejb.service.LibreriaService;

@Stateless
@Path("/")
public class RestController {

	@Inject
	private LibreriaService service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public AutoreDto getById(@PathParam("id") int id) {
		return service.getById(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("post")
	public void createAutore(AutoreDto nuovoAutore) {
		service.createAutore(nuovoAutore);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("post/autori")
	public void createAutori(List<AutoreDto> listaAutori) {
		service.test(listaAutori);
	}
	
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("remove")
	public void eliminaAutore(AutoreDto autoreToDelete) {
		service.deleteAutore(autoreToDelete);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("edit/{id}")
	public void modificaNome(@PathParam("id") int id, String nuovoNome) {
		service.updateNomeAutore(id, nuovoNome);
	}
	

}


