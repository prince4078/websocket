package com.register.register.chatapp.model;

import jakarta.validation.constraints.NotEmpty;

public class LoginDto {
	@NotEmpty(message="email cannot be empty ")
    private  String email;
	@NotEmpty(message="password cannot be empty")
    private  String password;
    
	public LoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    

}
