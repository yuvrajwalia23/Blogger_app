package com.example.blogger.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.blogger.BlogPost;
import com.example.blogger.repository.BlogPostRepository;
import com.example.blogger.repository.UserRepository;


@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private UserRepository userRepository;

    public BlogPostService() {
    }

    public BlogPost createPost(Long userId, BlogPost post) {
        System.out.println("Saving post for user ID: " + userId);
        
        return userRepository.findById(userId).map(user -> {
            post.setUser(user);
            post.setCreatedAt(LocalDateTime.now());
            return blogPostRepository.save(post);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<BlogPost> getAllPosts() {
        return blogPostRepository.findAll();
    }
    

    public Page<BlogPost> findAllPosts(Pageable pageable) {
        return blogPostRepository.findAll(pageable);
    }

    public List<BlogPost> getPostsByUserId(Long userId) {
        List<BlogPost> posts = blogPostRepository.findByUserId(userId);
        System.out.println("Returning " + posts.size() + " posts for user " + userId);
        return posts;
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
