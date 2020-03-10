package com.isi.spring.buddysconnect.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.isi.spring.buddysconnect.model.Posts;
import com.isi.spring.buddysconnect.model.User;
import com.isi.spring.buddysconnect.repository.IUserRepository;
import com.isi.spring.buddysconnect.repository.PostsRepository;

@Controller
public class PostController {
	
	@Autowired
	private PostsRepository postsRepository;
	
	@Autowired
	private IUserRepository userRepository;
	

	
	//private static String UPLOAD_FOLDER = "/buddysconnect/src/main/webapp/WEB-INF/images";
	
	
	@GetMapping("/postPage")
	public String createPost(Model model, HttpServletRequest request) {
		model.addAttribute("postForm", new Posts());
		model.addAttribute("name", request.getUserPrincipal().getName());

		return "postPage";
	}
	 
	
	@RequestMapping(value="/postPage",method =RequestMethod.POST )
	public String createPost(@ModelAttribute("postForm") Posts postForm, BindingResult result, HttpServletRequest request) {
		
		User user = userRepository.findByEmail(request.getUserPrincipal().getName());
		postForm.setUser(user);
		postsRepository.save(postForm);
		return "redirect:";
	}
	

}
