package com.spring.user.service;


import com.spring.user.model.UserDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

public class UserServiceImpl implements UserService {
    private final RestTemplate restTemplate;

    public UserServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    @Override
    public CompletableFuture<UserDto> findUser(Long userId) {
        String url = String.format("http://jsonplaceholder.typicode.com/users/%s", userId);
        return CompletableFuture.completedFuture(restTemplate.getForObject(url, UserDto.class));
    }
}
