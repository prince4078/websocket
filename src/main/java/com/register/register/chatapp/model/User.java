package com.register.register.chatapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class User {
	@Id
	@NotEmpty(message = "Email Field cannot be empty")
	String email;

	@NotEmpty(message = "Password Field cannot be empty")
	String password;

	@Pattern(regexp = "^[+]?[0-9]+([-]?[0-9]+)*$", message = "PhoneNumber must contain only Digits")
	@Size(min = 10, message = "Phone Number must contain 10 digits")
	@NotEmpty(message = "Phone Number cannot be empty")
	String phoneNumber;

	@Pattern(regexp = "^[a-zA-Z'-]+(?:\\s[a-zA-Z'-]+)*$", message = "Name must contain only alphabets")
	@Size(min = 3, max = 30, message = "Name must be in between 3 to 30 characters")
	@NotEmpty(message = "Full Name cannot be empty")
	String fullName;

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String email, String password, String phoneNumber, String fullName) {
		super();
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.fullName = fullName;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", phoneNumber=" + phoneNumber + ", fullName="
				+ fullName + "]";
	}
    
}
