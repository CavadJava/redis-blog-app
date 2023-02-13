package org.blog.app.service;

import lombok.RequiredArgsConstructor;
import org.blog.app.domain.Post;
import org.blog.app.repository.PostRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private static final String POSTS_CACHE_NAME = "posts";

    private final PostRepository postRepository;

    @Cacheable(value = POSTS_CACHE_NAME)
    public List<Post> findAll(){
        return postRepository.findAll();
    }

    @Cacheable(value = POSTS_CACHE_NAME, key = "#id")
    public Post findAllBy(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Caching(put = {
            @CachePut(value = POSTS_CACHE_NAME, key = "#post.id")
    }, evict = {
            @CacheEvict(value = POSTS_CACHE_NAME, allEntries = true)
    })
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Caching(evict = {
            @CacheEvict(value = POSTS_CACHE_NAME, allEntries = true),
            @CacheEvict(value = POSTS_CACHE_NAME, key = "#id")
    })
    public void remove(Long id) {
        postRepository.deleteById(id);
    }
}
