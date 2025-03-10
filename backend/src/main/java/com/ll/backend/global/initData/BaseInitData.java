package com.ll.backend.global.initData;

import com.ll.backend.post.Post;
import com.ll.backend.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {
    private final PostRepository postRepository;
    @Autowired
    @Lazy
    private BaseInitData self;

    @Bean
    public ApplicationRunner baseInitDataApplicationRunner() {
        return args -> {
            self.work1();
        };
    }

    @Transactional
    public void work1() {
        if(!postRepository.findAll().isEmpty()) return;

        Post post1 = new Post("title1", "content1");
        postRepository.save(post1);

        Post post2 = new Post("title2", "content2");
        postRepository.save(post2);

        Post post3 = new Post("title3", "content3");
        postRepository.save(post3);
    }
}
