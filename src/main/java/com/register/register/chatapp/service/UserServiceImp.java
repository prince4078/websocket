package com.register.register.chatapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.register.register.chatapp.model.User;
import com.register.register.chatapp.repository.UserRepository;
@Service
public class UserServiceImp  implements UserService{
    @Autowired
	private UserRepository userRepository ;
	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		return null;
	}
	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		User user=userRepository.findById(email).get(); 
		return user;
	}

}
