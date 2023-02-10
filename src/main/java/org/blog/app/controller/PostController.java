package org.blog.app.controller;

import lombok.RequiredArgsConstructor;
import org.blog.app.domain.Post;
import org.blog.app.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<Post> all() {
        return postService.findAll();
    }

    @PostMapping()
    public Post save(@RequestBody Post post) {
        return postService.save(post);
    }
}
