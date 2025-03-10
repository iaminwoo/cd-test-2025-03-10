package com.ll.backend.post;

import java.time.LocalDateTime;

record PostDto(Long id, String title, String content, LocalDateTime createdAt) {
    public PostDto(Post post) {
        this(post.getId(), post.getTitle(), post.getContent(), post.getCreatedAt());
    }
}