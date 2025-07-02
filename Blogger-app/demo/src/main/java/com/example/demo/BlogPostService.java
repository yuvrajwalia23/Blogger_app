package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private UserRepository userRepository;

    public BlogPostService() {
    }

    public BlogPost createPost(Long userId, BlogPost post) {
        return userRepository.findById(userId).map(user -> {
            post.setUser(user);
            post.setCreatedAt(LocalDateTime.now());
            return blogPostRepository.save(post);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<BlogPost> getAllPosts() {
        return blogPostRepository.findAll();
    }

    public List<BlogPost> getPostsByUserId(Long userId) {
        return blogPostRepository.findByUserId(userId);
    }

    public void deletePost(Long id) {
        blogPostRepository.deleteById(id);
    }

    public Optional<BlogPost> getPostById(Long id) {
        return blogPostRepository.findById(id);
    }

    public BlogPost updatePost(Long id, BlogPost updatedPost) {
        return blogPostRepository.findById(id).map(post -> {
            post.setTitle(updatedPost.getTitle());
            post.setContent(updatedPost.getContent());
            return blogPostRepository.save(post);
        }).orElseThrow(() -> new RuntimeException("Post not found"));
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
