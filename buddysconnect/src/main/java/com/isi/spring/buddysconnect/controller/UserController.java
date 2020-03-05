package com.isi.spring.buddysconnect.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
import com.isi.spring.buddysconnect.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private IUserRepository userRepository;
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

	@RequestMapping(value = "/login")
	public String loginPage() {
		return "home";
	}



	@GetMapping("/users") // GET Method for reading operation
	public List<User> getAllUsers() {
		return userRepository.findAll();
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
		userForm.setPassword( passwordEncoder.encode(userForm.getPassword()));
		userRepository.save(userForm);

		return "redirect:/login";
	}

	@RequestMapping(value = "/logout-success", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
			request.getSession().invalidate();
		}
		return "redirect:/";
	}
}
