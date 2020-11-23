package apiClient;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import models.DeleteProdRequest;
import models.Product;
import models.ResponseService;
import models.ResponseServiceMap;
import models.SetProdRequest;
import models.UpdatePassRequest;
import models.UpdateProdRequest;

public class RequestService {
	private String API_URL;
	private Client client;
	private WebTarget target;

	
	public RequestService() {    
	    ClientConfig config = new ClientConfig();
	    config.property(ClientProperties.SUPPRESS_HTTP_COMPLIANCE_VALIDATION, true);
		this.API_URL = "http://192.168.64.2/P07/public";
		this.client = ClientBuilder.newClient(config);
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
	
	public ResponseServiceMap getDetails(String user, String pass, String isbn) {
		return this.target
				   .path("getDetails")
				   .queryParam("user", user)
				   .queryParam("pass", pass)
				   .queryParam("isbn", isbn)
				   .request(MediaType.APPLICATION_JSON)
				   .get(ResponseServiceMap.class);
	}
	
	public ResponseServiceMap setProd(String user, String pass, String isbn, Product product) {
		SetProdRequest prodRequest = new SetProdRequest();
		
		prodRequest.user = user;
		prodRequest.pass = pass;
		prodRequest.isbn = isbn;
		prodRequest.product = product;
		
		return this.target
				.path("setProd")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(prodRequest, MediaType.APPLICATION_JSON), ResponseServiceMap.class);
	}
	
	public ResponseServiceMap updatePass(String user, String pass, String newPass) {
		UpdatePassRequest request = new UpdatePassRequest();
		
		request.user = user;
		request.pass = pass;
		request.newPass = newPass;
		
		return this.target
				.path("updatePass")
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(request, MediaType.APPLICATION_JSON), ResponseServiceMap.class);
	}
	
	public ResponseServiceMap updateProd(String user, String pass, Product newProduct) {
		UpdateProdRequest request = new UpdateProdRequest();
		
		request.user = user;
		request.pass = pass;
		request.product = newProduct;
		
		return this.target
				.path("updateProd")
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(request, MediaType.APPLICATION_JSON), ResponseServiceMap.class);
	}
	
	public ResponseService deleteProd(String user, String pass, String isbn) {
		DeleteProdRequest request = new DeleteProdRequest();
			
		request.user = user;
		request.pass = pass;
		request.isbn = isbn;
		
		return this.target
				.path("deleteProd")
				.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.build("DELETE", Entity.entity(request, MediaType.APPLICATION_JSON))
				.invoke(ResponseService.class);
	}
}
