package com.spring.user.contoller;


import com.spring.user.model.UserDetailDto;
import com.spring.user.service.aggregation.UserDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class UserDetailController {
    private final UserDetailService userDetailService;

    public UserDetailController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDetailDto> getUserDetail(@PathVariable Long userId) throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(userDetailService.findUserDetail(userId), HttpStatus.OK);
    }
}
