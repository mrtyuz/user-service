package com.spring.user.service;


import com.spring.user.model.UserCommentDto;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class UserCommentServiceTest {
    private UserCommentServiceImpl userCommentService;

    @Before
    public void setUp() {
        userCommentService = new UserCommentServiceImpl(new RestTemplateBuilder(), "http://jsonplaceholder.typicode.com/posts?userId=%s");
    }

    @Test
    public void createUserServiceTestObject() {
        assertNotNull(userCommentService);
    }

    @Test
    public void shouldReturnUserDtoWhenUserExist() throws ExecutionException, InterruptedException {
        assertNotNull(userCommentService.findUserComment(1L));
    }

    @Test
    public void shouldReturnEmptyArrayWhenUserCommentNotExist() throws ExecutionException, InterruptedException {
        CompletableFuture<UserCommentDto[]> userComment = userCommentService.findUserComment(100L);
        assertEquals(0, userComment.get().length);
    }
}
