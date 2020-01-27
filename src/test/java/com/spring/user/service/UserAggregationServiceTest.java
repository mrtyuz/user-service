package com.spring.user.service;


import com.spring.user.service.aggregation.UserDetailServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.concurrent.ExecutionException;

import static junit.framework.TestCase.assertNotNull;

public class UserAggregationServiceTest {
    private UserDetailServiceImpl userDetailService;

    @Before
    public void setUp() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        userDetailService = new UserDetailServiceImpl(new UserServiceImpl(restTemplateBuilder),
                new UserCommentServiceImpl(restTemplateBuilder));
    }

    @Test
    public void createUserDetailServiceTestObject() {
        assertNotNull(userDetailService);
    }

    @Test
    public void shouldReturnUserDetailDtoWhenUserExist() throws ExecutionException, InterruptedException {
        assertNotNull(userDetailService.findUserDetail(1L));
    }
}
