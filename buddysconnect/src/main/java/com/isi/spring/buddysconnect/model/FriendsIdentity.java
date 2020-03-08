package com.isi.spring.buddysconnect.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class FriendsIdentity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	private String relatingUserEmail;
	
	@NotNull
	private String relatedUserEmail;

	
	public FriendsIdentity() {
		
	}

	public FriendsIdentity(@NotNull String relatingUserEmail, @NotNull String relatedUserEmail) {
		super();
		this.relatingUserEmail = relatingUserEmail;
		this.relatedUserEmail = relatedUserEmail;
	}
	
	
}
