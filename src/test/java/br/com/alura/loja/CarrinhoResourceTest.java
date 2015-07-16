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

import com.thoughtworks.xstream.XStream;

public class CarrinhoResourceTest {

	private static final String LOCALHOST_URI = "http://localhost:8080";

	private HttpServer server;

	@Before
	public void setUp() throws Exception {
		server = GrizzlyServer.onUri("localhost").onPort("8080").enablingPackage("br.com.alura.loja").getServer();
		server.start();
	}
	
	@After
	public void setDown() {
		server.stop();
	}
	
	@Test
	public void deveriaRetornarOCarrinhoComOsDadosEsperadosUsandoQueryParam() throws Exception {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(LOCALHOST_URI);
		String conteudo = target.path("/carrinhos").queryParam("id", 1).request().get(String.class);
		
		Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		
		assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
	}
	
	@Test
	public void deveriaRetornarOCarrinhoComOsDadosEsperadosUsandoPathParam() throws Exception {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(LOCALHOST_URI);
		String conteudo = target.path("/carrinhos/1").request().get(String.class);
		
		Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		
		assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
	}
	
}
