package com.isi.spring.buddysconnect.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isi.spring.buddysconnect.model.Posts;

public interface PostsRepository extends JpaRepository<Posts, Integer> {

	List<Posts> findAll();

	List<Posts> findAllByUserEmail(String email);

	void save(Optional<Posts> posts);

	void deleteByPostId(int postId);
	Posts findByPostId(int postId);
	
	
}
