package com.isi.spring.buddysconnect.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.isi.spring.buddysconnect.model.Posts;
import com.isi.spring.buddysconnect.model.User;
import com.isi.spring.buddysconnect.repository.IFriendsRepository;
import com.isi.spring.buddysconnect.repository.IUserRepository;
import com.isi.spring.buddysconnect.repository.PostsRepository;
import com.isi.spring.buddysconnect.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private UserValidator userValidator;

	@Autowired
	private PostsRepository postsRepository;

	@Autowired
	private IFriendsRepository friendsRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		
		String loggedUser = request.getUserPrincipal().getName();
		List<Posts> listPosts = postsRepository.findAllByUserEmail(loggedUser);
		List<User> users = getAllUsers();
		model.addAttribute("posts",listPosts);
		model.addAttribute("users", users);
		String loggedInUserName=userRepository.findByEmail(loggedUser).getName();
		model.addAttribute("name", loggedInUserName);
		List<String> friendsList1 = friendsRepository.findByRelatedUserEmail(loggedUser,1);

		List<String> friendsList2 = friendsRepository.findByRelatingUserEmail(loggedUser,1);

		List<String> totalFriendsList = new ArrayList<String>(friendsList1);
		totalFriendsList.addAll(friendsList2);

		model.addAttribute("friendsList", totalFriendsList);

		List<String> friendRequestList = friendsRepository.findByRelatingUserEmail(loggedUser,0);

		model.addAttribute("friendsRequestList", friendRequestList);
		
		model.addAttribute("feed",postsRepository.findAll());

		// Search friends
		List<String> userEmails = new ArrayList<String>();
		for (User user : users) {
			userEmails.add(user.getEmail());
		}
		
		userEmails.removeAll(totalFriendsList);
		userEmails.removeAll(friendsRepository.findByRelatedUserEmail(loggedUser, 0));
		
		userEmails.remove(loggedUser);

		model.addAttribute("usersList", userEmails);
	
		return "home";
	}

	@RequestMapping(value = "/post/{id}")
	public String editPost(@PathVariable int id, Model model, HttpServletRequest request) {
		model.addAttribute("name", request.getUserPrincipal().getName());
		Optional<Posts> editposts = postsRepository.findById(id);
		model.addAttribute("editposts", editposts);
		// postsRepository.save(posts);
		return "home";
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String editPostSave(@PathVariable int id, Model model, HttpServletRequest request) {
		model.addAttribute("name", request.getUserPrincipal().getName());
		Optional<Posts> posts = postsRepository.findById(id);
		postsRepository.save(posts);
		return "home";
	}


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
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
		userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
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

	@RequestMapping(value = "/updatePassword")
	public String changePassword() {
		return "updatePassword";
	}

	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public String changePassword(@RequestParam String newPassword, HttpServletRequest request) {
		String encodedPassword = passwordEncoder.encode(newPassword);
		String loggedUser = request.getUserPrincipal().getName();
		User updateUserPassword = userRepository.findByEmail(loggedUser);
		updateUserPassword.setPassword(encodedPassword);
		userRepository.save(updateUserPassword);
		return "redirect:/login";
	}
	
	private void clearPosts(String userEmail) {
		List<Posts> posts=postsRepository.findAllByUserEmail(userEmail);

		for (Posts posts2 : posts) {
			postsRepository.deleteById(posts2.getPostId());
		}
	}
	
	@RequestMapping(value = "/clearAccount")
	public String clearAccount(HttpServletRequest request) {
		clearPosts(request.getUserPrincipal().getName());
		return "redirect:/";
	}

	@RequestMapping(value = "/deleteAccount")
	public String deleteUser(HttpServletRequest request) {
		String deleteUserMail=request.getUserPrincipal().getName();
		clearPosts(deleteUserMail);
		
		User deleteUser = userRepository.findByEmail(deleteUserMail);

		userRepository.delete(deleteUser);
		return "redirect:/login";
	}

	@RequestMapping("/viewFriendProfile/{friendMail}")
	public String viewFriendProfile(@PathVariable String friendMail, Model model, HttpServletRequest request) {
		
		List<Posts> listPosts = postsRepository.findAllByUserEmail(friendMail);
		List<User> users = getAllUsers();
		model.addAttribute("posts",listPosts);
		model.addAttribute("users", users);
		List<String> friendsList1 = friendsRepository.findByRelatedUserEmail(friendMail,1);

		List<String> friendsList2 = friendsRepository.findByRelatingUserEmail(friendMail,1);

		List<String> totalFriendsList = new ArrayList<String>(friendsList1);
		totalFriendsList.addAll(friendsList2);

		model.addAttribute("friendsList", totalFriendsList);

		return "viewFriendProfile";
	}
}
