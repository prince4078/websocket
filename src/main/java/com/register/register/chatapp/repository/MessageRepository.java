package com.register.register.chatapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.register.register.chatapp.model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
