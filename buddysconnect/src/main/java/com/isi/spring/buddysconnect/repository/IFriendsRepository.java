package com.isi.spring.buddysconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.isi.spring.buddysconnect.model.Friends;
import com.isi.spring.buddysconnect.model.FriendsIdentity;

@Repository
public interface IFriendsRepository extends JpaRepository<Friends, FriendsIdentity> {

	@Query("SELECT f.friendsIdentity.relatingUserEmail FROM Friends f WHERE f.friendsIdentity.relatedUserEmail=?1 and status=1")
	List<String> findByRelatedUserEmail(String userMail);

	@Query("SELECT f.friendsIdentity.relatedUserEmail FROM Friends f WHERE f.friendsIdentity.relatingUserEmail=?1 and status=1")
	List<String> findByRelatingUserEmail(String userMail);
	
	@Query("SELECT f.friendsIdentity.relatedUserEmail FROM Friends f WHERE f.friendsIdentity.relatingUserEmail=?1 and status=0")
	List<String> findByRelatingUserEmailRequest(String userMail);
	
	Friends findByFriendsIdentity(FriendsIdentity friendsIdentity);
	
	List<Friends> findAll();

	void deleteById(FriendsIdentity id) ;
	

}
