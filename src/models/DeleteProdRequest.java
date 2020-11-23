package models;

public class DeleteProdRequest extends PostRequest {
	public String isbn;
	
	public DeleteProdRequest(String user, String pass, String isbn) {
		super(user,pass);
		this.isbn = isbn;
	}
}
