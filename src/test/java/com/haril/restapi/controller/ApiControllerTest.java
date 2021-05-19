package com.haril.restapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.haril.restapi.dto.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author songkg7
 * @version 1.0.0
 * @since 2021/05/19 7:33 오후
 */
@AutoConfigureWebMvc
@WebMvcTest(ApiController.class)
class ApiControllerTest {

    private final String URL = "http://localhost:8080/api/best-practice";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("1. TEXT")
    @Test
    void test_1() throws Exception {
        mockMvc.perform(get(URL + "/text")
                .queryParam("account", "testAccount"))
                .andExpect(status().isOk())
                .andExpect(content().string("testAccount"))
                .andDo(print());
    }

    @DisplayName("2. JSON")
    @Test
    void test_2() throws Exception {

        User user = getUser();

        String content = objectMapper.writeValueAsString(user);

        MvcResult result = mockMvc.perform(post(URL + "/json")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        User responseUser = objectMapper.readValue(jsonResponse, User.class);

        assertEquals(user.getName(), responseUser.getName());
        assertEquals(user.getAge(), responseUser.getAge());
        assertEquals(user.getPhoneNumber(), responseUser.getPhoneNumber());
        assertEquals(user.getAddress(), responseUser.getAddress());

    }

    @DisplayName("3. ResponseEntity")
    @Test
    void test_3() throws Exception {
        User user = getUser();

        String content = objectMapper.writeValueAsString(user);

        mockMvc.perform(put(URL + "/put")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());

    }

    private User getUser() {
        User user = new User();
        user.setName("steve");
        user.setAge(30);
        user.setPhoneNumber("010-1111-2222");
        user.setAddress("seoul");
        return user;
    }
}