
package apiClient;

import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import models.ResGetCategorias;


public class Test {
	private String API_URL;
	private Client client;
	private WebTarget target;

	@PostConstruct
	public void init() {
		this.API_URL = "http://192.168.64.2/P07/public";
		this.client = ClientBuilder.newClient();
	    this.target = client.target(API_URL);
	}
	
	public ResGetCategorias test() {
		return this.target
				   .path("getProd")
				   .queryParam("user", "pruebas1")
				   .queryParam("pass","12345678a")
				   .queryParam("categoria", "libros")
				   .request(MediaType.APPLICATION_JSON)
				   .get(ResGetCategorias.class);
	}
}
