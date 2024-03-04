package com.register.register.chatapp.model;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer msgId;
	private String name;
	private String content;
	private Instant time;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(Integer msgId, String name, String content, Instant time) {
		super();
		this.msgId = msgId;
		this.name = name;
		this.content = content;
		this.time = time;
	}
	public Integer getMsgId() {
		return msgId;
	}
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Instant getTime() {
		return time;
	}
	public void setTime(Instant time) {
		this.time = time;
	}
}
