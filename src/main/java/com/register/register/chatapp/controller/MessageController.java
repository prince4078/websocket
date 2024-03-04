package com.register.register.chatapp.controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.register.register.chatapp.model.Message;
import com.register.register.chatapp.repository.MessageRepository;


@RestController
public class MessageController {
	@Autowired
	private MessageRepository messageRepository;
	@MessageMapping("/message")
	@SendTo("/topic/return-to")
	public Message getContent(@RequestBody Message message) {
		try {
			//processing if needed
			message.setTime(Instant.now());
			 messageRepository.save(message);
			Thread.sleep(100);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		return message;
	}

}
