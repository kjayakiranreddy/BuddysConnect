package com.isi.spring.buddysconnect.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "users") 
@EntityListeners(AuditingEntityListener.class)
public class User {
 
	@Column
	private String name;
	
	@Id
	private String email;
	
	@Column
	private String password;
	

	@Column
	private Date creationDate;
	
	public User() {}
	
	public User(String name, String email, String password, Date creationDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.creationDate = creationDate;
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

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", creationDate=" + creationDate
				+ "]";
	}


}
