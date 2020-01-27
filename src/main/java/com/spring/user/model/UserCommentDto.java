package com.spring.user.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCommentDto {
    private Long userId;
    private Long id;
    private String title;
    private String body;
}
