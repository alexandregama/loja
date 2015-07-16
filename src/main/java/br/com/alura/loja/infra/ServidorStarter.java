package br.com.alura.loja.infra;

import java.io.IOException;

import org.glassfish.grizzly.http.server.HttpServer;

public class ServidorStarter {

	public static void main(String[] args) {
		HttpServer server = GrizzlyServer.onUri("localhost").onPort("8080").enablingPackage("br.com.alura.loja").getServer();
		
		try {
			server.start();
			System.out.println("Server is running at http://localhost:8080");
			System.in.read();
			server.stop();
			System.out.println("Server is stopped");
		} catch (IOException e) {
			throw new RuntimeException("Ocorreu um erro ao subir o Server", e);
		}
	}
	
}
