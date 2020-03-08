package com.isi.spring.buddysconnect.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Posts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long postId;
	
	private String content;
	
	private String imagePath;
	
	 @Column(name = "postdate", nullable = false, updatable = false)
	 @CreationTimestamp
	private Date postDate;
	
	 
	 @ManyToOne
	 private User user;
	
	public Posts() {}

	public Posts( String content, String imagePath,User user) {
		super();
		this.content = content;
		this.imagePath = imagePath; 
		this.user=user;
		
	}


	public void setContent(String content) {
		this.content = content;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public long getPostId() {
		return postId;
	}

	public String getContent() {
		return content;
	}

	public String getImagePath() {
		return imagePath;
	}

	public Date getPostDate() {
		return postDate;
	}

	@Override
	public String toString() {
		return "Posts [postId=" + postId + ", content=" + content + ", imagePath=" + imagePath + ", postDate="
				+ postDate + "]";
	}


}
