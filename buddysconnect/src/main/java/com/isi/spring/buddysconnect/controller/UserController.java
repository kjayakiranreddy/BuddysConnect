package com.isi.spring.buddysconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.isi.spring.buddysconnect.model.User;
import com.isi.spring.buddysconnect.repository.IUserRepository;
import com.isi.spring.buddysconnect.service.MyUserDetailsService;
import com.isi.spring.buddysconnect.validator.UserValidator;

@Controller

public class UserController {

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private MyUserDetailsService myUserDeatailsService;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		return "login";
	}

	@RequestMapping("/login")
	public String loginPage() {
		return "welcome";
	}

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.POST) public String
	 * showWelcomePage(ModelMap model, @RequestParam("email") String
	 * email, @RequestParam String password) {
	 * 
	 * 
	 * boolean isValidUser = true;
	 * 
	 * if (!isValidUser) { model.put("errorMessage", "Invalid Credentials"); return
	 * "login"; }
	 * 
	 * model.put("email", email); model.put("password", password);
	 * 
	 * return "welcome"; }
	 */

	@GetMapping("/users") // GET Method for reading operation
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@PostMapping("/insertUser") // POST Method for Create operation
	public void createUser() {
		// myUserDeatailsService.saveUser(new User("Jayakiran", "test@test.com", "Test",
		// new Date()));
		// userRepository.save
	}

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "registration";
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		userRepository.save(userForm);

		return "redirect:/welcome";
	}
}
