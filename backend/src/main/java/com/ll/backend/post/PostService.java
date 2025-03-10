package com.ll.backend.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostDto> findAll() {
        return postRepository.findAll().stream().map(PostDto::new).toList();
    }

    public PostDto findById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        return new PostDto(post);
    }

    public PostDto createPost(String title, String content) {
        Post newPost = new Post(title, content);
        return new PostDto(postRepository.save(newPost));
    }

    public void deletePost(Long id) {
        Post toDelete = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        postRepository.delete(toDelete);
    }
}