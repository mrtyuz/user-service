package com.spring.user.service;


import com.spring.user.model.UserCommentDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

public class UserCommentServiceImpl implements UserCommentService {
    private final RestTemplate restTemplate;

    public UserCommentServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public CompletableFuture<UserCommentDto[]> findUserComment(Long userId) {
        String url = String.format("http://jsonplaceholder.typicode.com/posts?userId=%s", userId);
        return CompletableFuture.completedFuture(restTemplate.getForObject(url, UserCommentDto[].class));
    }
}
