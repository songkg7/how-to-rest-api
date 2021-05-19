package com.haril.restapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.haril.restapi.dto.PostRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author songkg7
 * @version 1.0.0
 * @since 2021/05/19 12:40 오후
 */
@AutoConfigureWebMvc
@WebMvcTest(PostController.class)
class PostControllerTest {

    private final String URL = "http://localhost:8080/api";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("1. Map<> 활용")
    @Test
    void test_1() throws Exception {

        Map<String, Object> requestData = new HashMap<>();
        requestData.put("name", "steve");
        requestData.put("email", "steve@gmail.com");
        requestData.put("age", 30);

        String content = objectMapper.writeValueAsString(requestData);

        mockMvc.perform(post(URL + "/post01")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @DisplayName("2. DTO")
    @Test
    void test_2() throws Exception {

        PostRequestDto dto = new PostRequestDto();
        dto.setAccount("testUser01");
        dto.setEmail("steve@gmail.com");
        dto.setAddress("seoul");
        dto.setOTP("1234567");
        dto.setPassword("1111");
        dto.setPhoneNumber("01011112222");

        String content = objectMapper.writeValueAsString(dto);

        mockMvc.perform(post(URL + "/post02")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}