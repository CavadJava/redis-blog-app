package org.blog.app.service;

import lombok.RequiredArgsConstructor;
import org.blog.app.domain.Post;
import org.blog.app.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    public Post save(Post post) {
        return postRepository.save(post);
    }
}
