package br.com.alura.loja;

import static org.junit.Assert.assertTrue;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Test;

public class ClientTest {

	private static final String MOCKY_IO_URL = "http://www.mocky.io";

	@Test
	public void testaQueAConexaoComOServidorFunciona() throws Exception {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(MOCKY_IO_URL);
		String conteudo = target.path("/v2/52aaf5deee7ba8c70329fb7d").request().get(String.class);
		
		assertTrue(conteudo.contains("<rua>Rua Vergueiro 3185"));
	}
	
}
