package com.spring.user.service;


import com.spring.user.exception.EntityNotFoundException;
import com.spring.user.model.UserDto;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class UserServiceImpl implements UserService {
    private final Logger log = Logger.getLogger(UserServiceImpl.class);
    private final RestTemplate restTemplate;
    private final String url;

    public UserServiceImpl(RestTemplateBuilder restTemplateBuilder,
                           @Value("${userServiceUrl}") String url) {
        this.restTemplate = restTemplateBuilder.build();
        this.url = url;
    }


    @Override
    @Async
    public CompletableFuture<UserDto> findUser(Long userId) {
        UserDto userDto;
        try {
            userDto = restTemplate.getForObject(String.format(url, userId), UserDto.class);
        } catch (HttpStatusCodeException ex) {
            log.error("User not found");
            throw new EntityNotFoundException("user not found for userId : " + userId);
        }
        return CompletableFuture.completedFuture(userDto);
    }
}
