package com.isi.spring.buddysconnect.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.isi.spring.buddysconnect.repository.IMessagesRepository;

@Controller
public class MessageController {
	
	@Autowired
	private IMessagesRepository messagesRepository;
	
	@RequestMapping(value = "/viewMessage/{friend}")
	public String viewMessages(@PathVariable String friend,Model model,HttpServletRequest request) {
		
		String loggedUser = request.getUserPrincipal().getName(); 
		List<String> userMessages=  messagesRepository.findAllByFromUserAndTOUser(loggedUser, friend);
		model.addAttribute("userMessages", userMessages);
		return "redirect:/";
	}
}
