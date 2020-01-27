package com.spring.user.service;


import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.concurrent.ExecutionException;

import static junit.framework.TestCase.assertNotNull;

public class UserCommentServiceTest {
    private UserCommentServiceImpl userCommentService;

    @Before
    public void setUp() {
        userCommentService = new UserCommentServiceImpl(new RestTemplateBuilder());
    }

    @Test
    public void createUserServiceTestObject() {
        assertNotNull(userCommentService);
    }

    @Test
    public void shouldReturnUserDtoWhenUserExist() throws ExecutionException, InterruptedException {
        assertNotNull(userCommentService.findUserComment(1L));
    }
}
