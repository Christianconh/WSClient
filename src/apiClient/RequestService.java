package apiClient;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import models.DeleteProdRequest;
import models.Product;
import models.ResponseService;
import models.ResponseServiceDate;
import models.ResponseServiceMap;
import models.ResponseServiceProduct;
import models.SetProdRequest;
import models.UpdatePassRequest;
import models.UpdateProdRequest;

public class RequestService {
	private String API_URL;
	private Client client;
	private WebTarget target;

	
	public RequestService() {
		this.API_URL = "http://192.168.64.2/P07/public";
		this.client = ClientBuilder.newClient();
	    this.target = client.target(API_URL);	
	}
	
	public ResponseServiceMap getProd(String user, String pass, String categoria) {
		return this.target
				   .path("getProd")
				   .queryParam("user", user)
				   .queryParam("pass", pass)
				   .queryParam("categoria", "libros")
				   .request(MediaType.APPLICATION_JSON)
				   .get(ResponseServiceMap.class);
	}
	
	public ResponseServiceProduct getDetails(String user, String pass, String isbn) {
		return this.target
				   .path("getDetails")
				   .queryParam("user", user)
				   .queryParam("pass", pass)
				   .queryParam("isbn", isbn)
				   .request(MediaType.APPLICATION_JSON)
				   .get(ResponseServiceProduct.class);
	}
	
	public ResponseServiceProduct setProd(String user, String pass, String isbn, Product product) {
		SetProdRequest prodRequest = new SetProdRequest(user,pass,isbn, product);
		return this.target
				.path("setProd")
				.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.json(prodRequest), ResponseServiceProduct.class);
	}
	
	public ResponseServiceDate updatePass(String user, String pass, String newPass) {
		UpdatePassRequest request = new UpdatePassRequest(user,pass,newPass);
		return this.target
				.path("updatePass")
				.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.put(Entity.json(request), ResponseServiceDate.class);
	}
	
	public ResponseServiceDate updateProd(String user, String pass, Product newProduct) {
		UpdateProdRequest request = new UpdateProdRequest(user,pass,newProduct);
		return this.target
				.path("updateProd")
				.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.put(Entity.json(request), ResponseServiceDate.class);
	}
	
	public ResponseService deleteProd(String user, String pass, String isbn) {
		DeleteProdRequest request = new DeleteProdRequest(user,pass,isbn);
		return this.target
				.path("updateProd")
				.request(MediaType.APPLICATION_JSON)
				.build("DELETE", Entity.entity(request, MediaType.APPLICATION_JSON))
				.invoke(ResponseService.class);
	}
}
