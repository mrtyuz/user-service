package com.spring.user.service;


import com.spring.user.exception.EntityNotFoundException;
import com.spring.user.model.UserDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class UserServiceImpl implements UserService {
    private final RestTemplate restTemplate;

    public UserServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    @Override
    @Async
    public CompletableFuture<UserDto> findUser(Long userId) {
        String url = String.format("http://jsonplaceholder.typicode.com/users/%s", userId);
        UserDto userDto;
        try {
            userDto = restTemplate.getForObject(url, UserDto.class);
        } catch (HttpStatusCodeException ex) {
            throw new EntityNotFoundException("user not found for userId : " + userId);
        }
        return CompletableFuture.completedFuture(userDto);
    }
}
