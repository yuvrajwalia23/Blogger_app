package com.example.blogger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogger.BlogPost;
import com.example.blogger.service.BlogPostService;

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

    // ✅ Pagination endpoint
    @GetMapping
    public Page<BlogPost> getAllPosts(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return blogPostService.findAllPosts(pageable);
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
