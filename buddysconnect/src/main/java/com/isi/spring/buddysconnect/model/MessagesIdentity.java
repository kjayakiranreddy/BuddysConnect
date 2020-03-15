package com.isi.spring.buddysconnect.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

@Embeddable
public class MessagesIdentity implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String fromUser;
	
	@NotNull
	private String toUser;
	

	@CreationTimestamp
	private Date messageDate;

	public MessagesIdentity() {
		
	}

	public MessagesIdentity(@NotNull String fromUser, @NotNull String toUser, Date messageDate) {
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.messageDate = messageDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fromUser == null) ? 0 : fromUser.hashCode());
		result = prime * result + ((messageDate == null) ? 0 : messageDate.hashCode());
		result = prime * result + ((toUser == null) ? 0 : toUser.hashCode());
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
		MessagesIdentity other = (MessagesIdentity) obj;
		if (fromUser == null) {
			if (other.fromUser != null)
				return false;
		} else if (!fromUser.equals(other.fromUser))
			return false;
		if (messageDate == null) {
			if (other.messageDate != null)
				return false;
		} else if (!messageDate.equals(other.messageDate))
			return false;
		if (toUser == null) {
			if (other.toUser != null)
				return false;
		} else if (!toUser.equals(other.toUser))
			return false;
		return true;
	}

}
