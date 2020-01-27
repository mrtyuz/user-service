package com.spring.user.service;


import com.spring.user.model.UserCommentDto;

public class UserCommentServiceImpl implements UserCommentService {
    @Override
    public UserCommentDto findUserComment() {
        return UserCommentDto.builder().build();
    }
}
