package org.blog.app.service;

import lombok.RequiredArgsConstructor;
import org.blog.app.domain.Post;
import org.blog.app.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Post findAllBy(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void remove(Long id) {
        postRepository.deleteById(id);
    }
}
