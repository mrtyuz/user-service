package com.spring.user.service;


import com.spring.user.exception.EntityNotFoundException;
import com.spring.user.model.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static junit.framework.TestCase.assertNotNull;

public class UserServiceTest {
    private UserServiceImpl userService;

    @Before
    public void setUp() {
        userService = new UserServiceImpl(new RestTemplateBuilder(), "http://jsonplaceholder.typicode.com/users/%s");
    }

    @Test
    public void createUserServiceTestObject() {
        assertNotNull(userService);
    }

    @Test
    public void shouldReturnUserDtoWhenUserExist() throws ExecutionException, InterruptedException {
        CompletableFuture<UserDto> user = userService.findUser(1L);
        assertNotNull(user);
    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldHandleWhenUserNotExist() throws ExecutionException, InterruptedException {
        CompletableFuture<UserDto> user = userService.findUser(100L);
        assertNotNull(user);
    }
}
