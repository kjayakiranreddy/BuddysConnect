package com.isi.spring.buddysconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isi.spring.buddysconnect.model.Friends;
import com.isi.spring.buddysconnect.model.FriendsIdentity;

@Repository
public interface IFriendsRepository extends JpaRepository<Friends, FriendsIdentity>{

}
