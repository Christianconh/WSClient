package models;

public class SetProdRequest extends PostRequest {
	public String isbn;
	public Product product;

	public SetProdRequest(String user, String pass, String _isbn, Product _product) {
		super(user,pass);
		this.isbn = _isbn;
		this.product = _product;
	}
}
