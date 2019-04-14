package masi_green.model.request;

import com.google.gson.annotations.SerializedName;

public class RegisterUserRequest {

	@SerializedName("login")
	private String login;
	
	@SerializedName("password")
	private String password;
	
	@SerializedName("name")
	private String name;

	@SerializedName("surname")
	private String surname;

	@SerializedName("email")
	private String email;

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}
}
