package com.register.register.chatapp.service;

import com.register.register.chatapp.model.User;

public interface UserService {
	public String addUser(User user);
	public User getUser(String email);

}
