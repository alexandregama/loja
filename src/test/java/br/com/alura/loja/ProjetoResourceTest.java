package br.com.alura.loja;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.alura.loja.infra.GrizzlyServer;
import br.com.alura.loja.modelo.Projeto;

import com.thoughtworks.xstream.XStream;

public class ProjetoResourceTest {
	
	private static final String LOCALHOST_URI = "http://localhost:8080";

	private HttpServer server;

	@Before
	public void setUp() {
		server = GrizzlyServer.onUri("localhost").onPort("8080").enablingPackage("br.com.alura.loja").getServer();
	}
	
	@After
	public void setDown() {
		server.stop();
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
