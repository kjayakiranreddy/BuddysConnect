package com.isi.spring.buddysconnect.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isi.spring.buddysconnect.model.Friends;
import com.isi.spring.buddysconnect.model.FriendsIdentity;
import com.isi.spring.buddysconnect.repository.IFriendsRepository;

@Controller
public class FriendController {

	@Autowired
	private IFriendsRepository iFriendsRepository;

	@RequestMapping("/removeFriend/{removeFriendMail}")
	public String removeFriend(@PathVariable String removeFriendMail, HttpServletRequest request) {
		try {
			iFriendsRepository.deleteById(new FriendsIdentity(request.getUserPrincipal().getName(), removeFriendMail));
		} catch (Exception e) {
			iFriendsRepository.deleteById(new FriendsIdentity(removeFriendMail, request.getUserPrincipal().getName()));
		}
		return "redirect:/";
	}

	@RequestMapping("/addFriend/{addFriendMail}")
	public String addFriend(@PathVariable String addFriendMail, HttpServletRequest request) {

		iFriendsRepository
				.save(new Friends(new FriendsIdentity(request.getUserPrincipal().getName(), addFriendMail), 0));
		return "redirect:/";
	}

	@RequestMapping("/confirmFriendRequest/{confirmFriendMail}")
	public String confirmFriend(@PathVariable String confirmFriendMail, HttpServletRequest request) {

		Friends friends = iFriendsRepository
				.findByFriendsIdentity(new FriendsIdentity(confirmFriendMail, request.getUserPrincipal().getName()));
		friends.setStatus(1);

		iFriendsRepository.save(friends);
		return "redirect:/";
	}

	@RequestMapping("/removeFriendRequest/{removeFriendRequestMail}")
	public String deleteFriendRequest(@PathVariable String removeFriendRequestMail, HttpServletRequest request) {

		iFriendsRepository
				.deleteById(new FriendsIdentity(removeFriendRequestMail,request.getUserPrincipal().getName()));
		return "redirect:/";
	}

}
