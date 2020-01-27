package com.spring.user.service.aggregation;

import com.spring.user.model.UserDetailDto;

import java.util.concurrent.ExecutionException;

public interface UserDetailService {
    UserDetailDto findUserDetail(Long userId) throws ExecutionException, InterruptedException;
}
