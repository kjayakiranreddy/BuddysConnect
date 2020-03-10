package com.isi.spring.buddysconnect.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

	public static String upload_dir = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
			+ File.separator + "resources" + File.separator + "static" + File.separator + "images";

	@GetMapping("/postPage")
	public String createPost(Model model, HttpServletRequest request) {
		model.addAttribute("postForm", new Posts());
		model.addAttribute("name", request.getUserPrincipal().getName());

		return "postPage";
	}

	@RequestMapping(value = "/postPage", method = RequestMethod.POST)
	public String createPost(@ModelAttribute("postForm") Posts postForm, @RequestParam("media") MultipartFile[] files,
			@RequestParam("content") String content, HttpServletRequest request, BindingResult result) {
		String imagePath = null;
		StringBuilder fileNames = new StringBuilder();
		for (MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(upload_dir, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename());
			try {
				imagePath = file.getOriginalFilename();
				Files.write(fileNameAndPath, file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		User user = userRepository.findByEmail(request.getUserPrincipal().getName());
		postForm.setUser(user);
		postForm.setImagePath(imagePath);
		postsRepository.save(postForm);

		return "redirect:/";
	}

	@Transactional
	@RequestMapping(value = "/deletePost")
	public String deletePost(@RequestParam int postId) {
		postsRepository.deleteByPostId(postId);
		return "redirect:/";
	}

	@Transactional
	@RequestMapping(value = "/editPost")
	public String editPost(@RequestParam String content, @RequestParam int postId, Model model) {
		System.out.println("in edit post" + content + " id is :" + postId);
		model.addAttribute("content", content);
		model.addAttribute("postId", postId);
		return "editPost";
	}

	@Transactional
	@RequestMapping(value = "/updatePost/{postId}")
	public String updatePost(HttpServletRequest request, @PathVariable int postId) {
		System.out.println(postId);
		String updatedContent = null;
		updatedContent = request.getParameter("updatedContent");
		if (updatedContent != null && postId >= 0) {
			Posts post = postsRepository.findByPostId(postId);
			post.setContent(updatedContent);
			postsRepository.save(post);
		}
		return "redirect:/";


	}

}
