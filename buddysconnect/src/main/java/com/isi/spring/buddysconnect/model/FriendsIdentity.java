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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((relatedUserEmail == null) ? 0 : relatedUserEmail.hashCode());
		result = prime * result + ((relatingUserEmail == null) ? 0 : relatingUserEmail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FriendsIdentity other = (FriendsIdentity) obj;
		if (relatedUserEmail == null) {
			if (other.relatedUserEmail != null)
				return false;
		} else if (!relatedUserEmail.equals(other.relatedUserEmail))
			return false;
		if (relatingUserEmail == null) {
			if (other.relatingUserEmail != null)
				return false;
		} else if (!relatingUserEmail.equals(other.relatingUserEmail))
			return false;
		return true;
	}
	
	
}
