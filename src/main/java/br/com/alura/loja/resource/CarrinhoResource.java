package br.com.alura.loja.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alura.loja.dao.Carrinhos;
import br.com.alura.loja.dao.HashMapCarrinhoDao;
import br.com.alura.loja.modelo.Carrinho;

@Path("carrinhos")
public class CarrinhoResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String busca() {
		Carrinhos carrinhos = new HashMapCarrinhoDao();
		Carrinho carrinho = carrinhos.busca(1L);
		
		return carrinho.toXml();
	}
	
}
