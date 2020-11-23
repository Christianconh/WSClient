package models;

public class UpdateProdRequest extends PostRequest {
	public Product product;
	
	public UpdateProdRequest(String user, String pass, Product product) {
		super(user,pass);
		this.product = product;
	}
}
