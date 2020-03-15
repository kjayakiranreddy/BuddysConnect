package com.isi.spring.buddysconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.isi.spring.buddysconnect.model.Messages;
import com.isi.spring.buddysconnect.model.MessagesIdentity;

public interface IMessagesRepository extends JpaRepository<Messages, MessagesIdentity>{
	
	@Query("SELECT m.message   FROM Messages m WHERE m.messagesIdentity.fromUser=?1 AND m.messagesIdentity.toUser=?2")
	List<String> findAllByFromUserAndTOUser(String email1, String email2);
	


}
