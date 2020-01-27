package com.spring.user.service;


import com.spring.user.model.UserDto;

import java.util.concurrent.CompletableFuture;

public interface UserService {
    CompletableFuture<UserDto> findUser(Long userId);
}
