package com.spring.user.contoller;

import com.spring.user.service.UserCommentService;
import com.spring.user.service.aggregation.UserDetailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserDetailController.class)
public class UserDetailControllerTestMockMvcTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserDetailService userDetailService;

    @MockBean
    UserCommentService userCommentService;



    @Test
    public void shouldGetWhenAmountIsValid() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/user/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}