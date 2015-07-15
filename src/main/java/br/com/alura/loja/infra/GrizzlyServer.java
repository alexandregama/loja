package br.com.alura.loja.infra;

import java.net.URI;
import java.net.URISyntaxException;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;


public class GrizzlyServer {

	private String uri;

	public GrizzlyServer(String uri) {
		this.uri = uri;
	}

	public static GrizzlyServer onUri(String uri) {
		return new GrizzlyServer(uri);
	}

	public GrizzlyServerPort onPort(String port) {
		return new GrizzlyServerPort(port);
	}
	
	public class GrizzlyServerPort {

		private String port;

		public GrizzlyServerPort(String port) {
			this.port = port;
		}

		public GrizzlyServerStarter enablingPackage(String packageName) {
			return new GrizzlyServerStarter(port, packageName);
		}
	}
	
	public class GrizzlyServerStarter {

		private String port;
		private String packageName;
		private HttpServer server;

		public GrizzlyServerStarter(String port, String packageName) {
			this.port = port;
			this.packageName = packageName;
		}

		public HttpServer getServer() {
			URI completeUri;
			try {
				completeUri = new URI("http://" +  uri + ":" + port + "/");
				ResourceConfig config = new ResourceConfig().packages(packageName);
				server = GrizzlyHttpServerFactory.createHttpServer(completeUri , config);
				try {
					return server;
				} catch (Exception e) {
					throw new RuntimeException("Ocorreu um erro ao startar o Server do Grizzly", e);
				}
			} catch (URISyntaxException e) {
				throw new RuntimeException("Ocorreu um erro ao montar a url de acesso para o Server do Grizzly", e);
			}
		}
		
	}
	
}
