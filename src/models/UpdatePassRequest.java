package models;

public class UpdatePassRequest extends PostRequest {
	public String newPass;
	
	public UpdatePassRequest(String user, String pass, String newPass) {
		super(user,pass);
		this.newPass = newPass;
	}
}
