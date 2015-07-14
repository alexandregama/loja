package br.com.alura.loja.infra;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class ServidorStarter {

	public static void main(String[] args) {
		URI uri;
		try {
			uri = new URI("http://localhost:8080/");
			ResourceConfig config = new ResourceConfig().packages("br.com.alura.loja");
			HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri , config);
			System.out.println("Servidor rodando");
			try {
				System.in.read();
				server.stop();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
}
