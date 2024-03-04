package com.register.register.chatapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.register.register.chatapp.model.User;

public interface UserRepository extends JpaRepository<User, String>{

}
