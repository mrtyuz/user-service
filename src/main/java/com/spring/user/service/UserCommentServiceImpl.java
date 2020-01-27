package com.spring.user.service;


import com.spring.user.model.UserCommentDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class UserCommentServiceImpl implements UserCommentService {
    private final RestTemplate restTemplate;
    private final String url;

    public UserCommentServiceImpl(RestTemplateBuilder restTemplateBuilder,
                                  @Value("${userCommentServiceUrl}") String url) {
        this.url = url;
        this.restTemplate = restTemplateBuilder.build();

    }

    @Override
    @Async
    public CompletableFuture<UserCommentDto[]> findUserComment(Long userId) {
        return CompletableFuture.completedFuture(restTemplate.getForObject(String.format(url, userId), UserCommentDto[].class));
    }
}
