package br.com.alura.loja;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.alura.loja.infra.GrizzlyServer;
import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Projeto;

import com.thoughtworks.xstream.XStream;

public class ClientTest {

	private static final String LOCALHOST_URI = "http://localhost:8080";

	private static final String MOCKY_IO_URL = "http://www.mocky.io";
	
	private HttpServer server;

	@Before
	public void setUp() {
		server = GrizzlyServer.onUri("localhost").onPort("8080").enablingPackage("br.com.alura.loja").start();
	}
	
	@After
	public void setDown() {
		server.stop();
	}
	
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
		WebTarget target = client.target(LOCALHOST_URI);
		String conteudo = target.path("/carrinhos").request().get(String.class);
		
		Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		
		assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
	}
	
	@Test
	public void deveriaRetornarOProdutoComOsDadosEsperados() throws Exception {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(LOCALHOST_URI);
		String conteudo = target.path("/projetos").request().get(String.class);
		
		Projeto projeto = (Projeto) new XStream().fromXML(conteudo);
		
		assertEquals("Casa do Codigo", projeto.getNome());
	}
	
}
