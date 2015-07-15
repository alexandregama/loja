package br.com.alura.loja;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Assert;
import org.junit.Test;

import br.com.alura.loja.modelo.Carrinho;

import com.thoughtworks.xstream.XStream;

public class ClientTest {

	private static final String MOCKY_IO_URL = "http://www.mocky.io";

	@Test
	public void testaQueAConexaoComOServidorFunciona() throws Exception {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(MOCKY_IO_URL);
		String conteudo = target.path("/v2/52aaf5deee7ba8c70329fb7d").request().get(String.class);
		
		assertTrue(conteudo.contains("<rua>Rua Vergueiro 3185"));
	}
	
	@Test
	public void deveriaRetornarOCarrinhoComOsDadosEsperados() throws Exception {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/carrinhos").request().get(String.class);
		
		Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		
		assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
	}
	
}
