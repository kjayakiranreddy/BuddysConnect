package com.isi.spring.buddysconnect.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.isi.spring.buddysconnect.model.User;


public interface IUserRepository extends JpaRepository<User, String> {

	User findByEmail(String email);

}


