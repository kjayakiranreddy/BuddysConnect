package com.isi.spring.buddysconnect.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@Table(name = "users") 
@EntityListeners(AuditingEntityListener.class)
public class User {
 
	@Column(nullable = false)
	private String name;
	
	@Id
	@Column(nullable = false, updatable = false)
	private String email;
	
	@Column
	private String password;
	
	
	@OneToMany
	@JoinColumn(name="user_email")
	private List<Posts> posts = new ArrayList<>();

	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date creationDate;
	
	@ManyToMany
	private List<Friends> friends;
	
	@ManyToMany
	private List<Messages> messages;
	
	public User() {}
	
	public User(String name, String email, String password, Date creationDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.creationDate = creationDate;
	}

	public List<Posts> getPosts() {
		return posts;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", posts=" + posts
				+ ", creationDate=" + creationDate + "]";
	}


}
