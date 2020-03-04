package com.isi.spring.buddysconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.isi.spring.buddysconnect.model.User;
import com.isi.spring.buddysconnect.repository.IUserRepository;
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserRepository iUserRepository;
	

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = iUserRepository.findByEmail(email);
		if(user==null)
			throw new UsernameNotFoundException("User Not found");
		
		return new UserPrincipal(user);
	}
	

	public User findByUsername(String email) {
		
		return iUserRepository.findByEmail(email);
	}
	
	/*
	 * public User saveUser(User user) {
	 * user.setPassword(bCryptPasswordEncoder.encode(user.getPassword())); return
	 * iUserRepository.save(user); }
	 */
	 

}
