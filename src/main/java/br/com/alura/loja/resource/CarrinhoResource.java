package br.com.alura.loja.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.alura.loja.dao.Carrinhos;
import br.com.alura.loja.dao.HashMapCarrinhoDao;
import br.com.alura.loja.modelo.Carrinho;

@Path("carrinhos")
public class CarrinhoResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String busca(@QueryParam("id") Long id) {
		Carrinhos carrinhos = new HashMapCarrinhoDao();
		Carrinho carrinho = carrinhos.busca(id);
		
		return carrinho.toXml();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String pesquisa(@PathParam("id") Long id) {
		Carrinhos carrinhos = new HashMapCarrinhoDao();
		
		Carrinho carrinho = carrinhos.busca(id);
		
		return carrinho.toXml();
	}
	
	@GET
	@Path("{id}/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String pesquisaJson(@PathParam("id") Long id) {
		Carrinhos carrinhos = new HashMapCarrinhoDao();
		
		Carrinho carrinho = carrinhos.busca(id);
		
		return carrinho.toJson();
	}
	
}
