package com.spring.user.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetailDto {
    private UserDto user;
    private UserCommentDto[] userComments;
}
