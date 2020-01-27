package com.spring.user.service;


import com.spring.user.model.UserCommentDto;

import java.util.concurrent.CompletableFuture;

public interface UserCommentService {
    CompletableFuture<UserCommentDto[]> findUserComment(Long userId);
}
