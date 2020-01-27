package com.spring.user.service;


import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static junit.framework.TestCase.assertNotNull;

public class UserCommentServiceTest {
    private UserCommentServiceImpl userCommentService;

    @Before
    public void setUp() {
        userCommentService = new UserCommentServiceImpl();
    }

    @Test
    public void createUserServiceTestObject() {
        assertNotNull(userCommentService);
    }

    @Test
    public void shouldReturnUserDtoWhenUserExist() throws ExecutionException, InterruptedException {
        assertNotNull(userCommentService.findUserComment());
    }
}
