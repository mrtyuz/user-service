package com.spring.user.service;


import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class UserCommentServiceTest {

    @Test
    public void createUserServiceTestObject() {
        UserCommentServiceImpl userCommentService = new UserCommentServiceImpl();
        assertNotNull(userCommentService);
    }
}
