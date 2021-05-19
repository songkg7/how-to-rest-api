package com.haril.restapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.haril.restapi.dto.UserRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author songkg7
 * @version 1.0.0
 * @since 2021/05/18 11:13 오후
 */
@AutoConfigureWebMvc
@WebMvcTest(GetController.class)
class GetControllerTest {

    private final String URL = "http://localhost:8080/api";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("1. GET : RequestMapping(~) ")
    @Test
    void test_1() throws Exception {

        mockMvc.perform(get(URL + "/get/hi"))
                .andExpect(status().isOk())
                .andExpect(content().string("get hi"))
                .andDo(print());

    }

    @DisplayName("2. GET : 명시적 경로 설정")
    @Test
    void test_2() throws Exception {

        mockMvc.perform(get(URL + "/get/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("get Hello"))
                .andDo(print());

    }

    @DisplayName("3. GET : hello - simple coding (Best Practice!)")
    @Test
    void test_3() throws Exception {

        mockMvc.perform(get(URL + "/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"))
                .andDo(print());

    }

    @DisplayName("4. PathVariable")
    @Test
    void test_4() throws Exception {

        String urlName = "steve";
        mockMvc.perform(get(URL + "/path-variable01/{name}", urlName))
                .andExpect(status().isOk())
                .andExpect(content().string(urlName))
                .andDo(print());

    }

    @DisplayName("5. Query Parameter 01")
    @Test
    void test_5() throws Exception {
        mockMvc.perform(get(URL + "/query-param01")
                .queryParam("name", "steve")
                .queryParam("age", "30"))
                .andExpect(status().isOk())
                .andExpect(content().string("name = steve" + "\n" + "age = 30" + "\n"))
                .andDo(print());

    }

    @DisplayName("6. Query Parameter 02 - 명시적 지정")
    @Test
    void test_6() throws Exception {
        mockMvc.perform(get(URL + "/query-param02")
                .queryParam("name", "steve")
                .queryParam("email", "steve@gmail.com")
                .queryParam("age", "30"))
                .andExpect(status().isOk())
                .andExpect(content().string("steve steve@gmail.com 30"))
                .andDo(print());
    }

    @DisplayName("7. Query Parameter 03 - DTO (Best Practice!)")
    @Test
    void test_7() throws Exception {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("name", "steve");
        params.add("email", "steve@gmail.com");
        params.add("age", "30");

        MvcResult result = mockMvc.perform(get(URL + "/query-param03")
                .queryParams(params))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        UserRequestDto userRequestDto = objectMapper.readValue(content, UserRequestDto.class);

        assertEquals(userRequestDto.getName(), "steve");
        assertEquals(userRequestDto.getEmail(), "steve@gmail.com");
        assertEquals(userRequestDto.getAge(), 30);

    }

}