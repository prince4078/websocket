package com.register.register.chatapp.controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.register.register.chatapp.config.SchedulerExample;
import com.register.register.chatapp.model.BidAmount;
import com.register.register.chatapp.model.Message;
import com.register.register.chatapp.repository.BidAmountRepository;
import com.register.register.chatapp.repository.MessageRepository;


@RestController
public class MessageController {
    
	private SchedulerExample schedularExample;
    @Autowired
	public MessageController() {
		super();
		schedularExample.scheduleTasks();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private BidAmountRepository bidAmountRepository;
	@MessageMapping("/message")
	@SendTo("/topic/return-to")
	public Message getContent(@RequestBody Message message) {
		try {
			//processing if needed
			message.setTime(Instant.now());
			 messageRepository.save(message);
			 BidAmount bidAmount=new BidAmount();
			 bidAmount.setTime(Instant.now());
			 bidAmount.setAmount(message.getAmount());
			 bidAmount.setName(message.getName());
			 bidAmountRepository.save(bidAmount);
			 result();
			Thread.sleep(100);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		return message;
	}
  
	private BidAmount result() {
		BidAmount res=bidAmountRepository.findByMaxAmount().get();
		System.out.println(res.getAmount()+res.getName());
		return res;
	}

}
