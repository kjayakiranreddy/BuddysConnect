package com.isi.spring.buddysconnect.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Messages {
	
	@EmbeddedId
	private MessagesIdentity messagesIdentity;
	
	@Column
	private String message;
	
	@Column
	private int seen;
	
	@ManyToMany(mappedBy = "messages")
	private List<User> users;

	public MessagesIdentity getMessagesIdentity() {
		return messagesIdentity;
	}

	public void setMessagesIdentity(MessagesIdentity messagesIdentity) {
		this.messagesIdentity = messagesIdentity;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getSeen() {
		return seen;
	}

	public void setSeen(int seen) {
		this.seen = seen;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Messages() {
		
	}
	
	public Messages(MessagesIdentity messagesIdentity, String message, int seen, List<User> users) {
		this.messagesIdentity = messagesIdentity;
		this.message = message;
		this.seen = seen;
		this.users = users;
	}

		
}
