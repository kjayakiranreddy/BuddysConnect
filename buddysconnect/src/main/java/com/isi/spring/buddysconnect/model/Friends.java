package com.isi.spring.buddysconnect.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Friends{
	
	@EmbeddedId
	private FriendsIdentity friendsIdentity;
	
	@Column
	private int status;
	
	@ManyToMany(mappedBy = "friends")
	private List<User> users;

	public FriendsIdentity getFriendsIdentity() {
		return friendsIdentity;
	}

	public void setFriendsIdentity(FriendsIdentity friendsIdentity) {
		this.friendsIdentity = friendsIdentity;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	
	public Friends() {
		
	}

	public Friends(FriendsIdentity friendsIdentity, int status) {
		this.friendsIdentity = friendsIdentity;
		this.status = status;
	}
	
	public Friends(FriendsIdentity friendsIdentity, int status, List<User> users) {
		this.friendsIdentity = friendsIdentity;
		this.status = status;
		this.users = users;
	}
	
	
}
