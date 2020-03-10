package com.isi.spring.buddysconnect.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
@Embeddable
public class LikeIdentity implements Serializable{
	@NotNull
	private int postId;
	@NotNull
	private String email;
	
	public LikeIdentity()
	{
		
	}
	public LikeIdentity(@NotNull int postId, @NotNull String email) {
		super();
		this.postId = postId;
		this.email = email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + postId;
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
		LikeIdentity other = (LikeIdentity) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (postId != other.postId)
			return false;
		return true;
	}

}
