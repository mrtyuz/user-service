package com.spring.user.service;


import com.spring.user.service.aggregation.UserDetailServiceImpl;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class UserAggregationServiceTest {
    @Test
    public void createUserDetailServiceTestObject() {
        UserDetailServiceImpl userDetailService = new UserDetailServiceImpl();
        assertNotNull(userDetailService);
    }
}
