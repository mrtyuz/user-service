package com.spring.user.service.aggregation;

import com.spring.user.model.UserCommentDto;
import com.spring.user.model.UserDetailDto;
import com.spring.user.model.UserDto;
import com.spring.user.service.UserCommentService;
import com.spring.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class UserDetailServiceImpl implements UserDetailService {
    private final UserService userService;
    private final UserCommentService userCommentService;

    public UserDetailServiceImpl(UserService userService, UserCommentService userCommentService) {
        this.userService = userService;
        this.userCommentService = userCommentService;
    }
    @Override
    public UserDetailDto findUserDetail(Long userId) throws ExecutionException, InterruptedException {
        CompletableFuture<UserDto> user = userService.findUser(userId);
        CompletableFuture<UserCommentDto[]> userComments = userCommentService.findUserComment(userId);
        CompletableFuture.allOf(user, userComments).join();
        return UserDetailDto.builder().user(user.get()).userComments(userComments.get()).build();
    }
}
