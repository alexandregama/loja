package br.com.alura.loja.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.alura.loja.dao.HashMapProjetoDao;
import br.com.alura.loja.dao.Projetos;
import br.com.alura.loja.modelo.Projeto;

@Path("projetos")
public class ProjetoResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String busca(@QueryParam("id") Long id) {
		Projetos projetos = new HashMapProjetoDao();
		
		Projeto projeto = projetos.busca(id);
		
		return projeto.toXml();
	}
	
}
