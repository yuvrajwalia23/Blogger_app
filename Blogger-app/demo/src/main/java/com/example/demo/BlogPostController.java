package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping("/{userId}")
    public BlogPost createPost(@PathVariable Long userId, @RequestBody BlogPost post) {
        return blogPostService.createPost(userId, post);
    }

    @GetMapping
    public List<BlogPost> getAllPosts() {
        return blogPostService.getAllPosts();
    }

    @GetMapping("/user/{userId}")
    public List<BlogPost> getUserPosts(@PathVariable Long userId) {
        return blogPostService.getPostsByUserId(userId);
    }

    @GetMapping("/{postId}")
    public BlogPost getPostById(@PathVariable Long postId) {
        return blogPostService.getPostById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    @PutMapping("/{postId}")
    public BlogPost updatePost(@PathVariable Long postId, @RequestBody BlogPost post) {
        return blogPostService.updatePost(postId, post);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {
        blogPostService.deletePost(postId);
    }
}
