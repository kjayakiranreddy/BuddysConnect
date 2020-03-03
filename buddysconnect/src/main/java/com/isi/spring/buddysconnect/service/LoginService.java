package com.isi.spring.buddysconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isi.spring.buddysconnect.repository.IUserRepository;

@Service
public class LoginService {

	@Autowired
	private IUserRepository iUserRepository;
	public boolean vlaidateUser(String email,String password) {
		return true;
	}
}
