package br.com.alura.loja.infra;

public class ServidorStarter {

	public static void main(String[] args) {
		GrizzlyServer.onUri("http://localhost").onPort("8080").enablingPackage("br.com.alura.loja").start();
	}
	
}
