package com.haril.restapi.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

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

    final String URI = "http://localhost:8080/api/";

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("1. GET : RequestMapping(~) ")
    @Test
    void test_1() throws Exception {

        mockMvc.perform(get(URI + "/get/hi"))
                .andExpect(status().isOk())
                .andExpect(content().string("get hi"))
                .andDo(print());

    }

    @DisplayName("2. GET : 명시적 경로 설정")
    @Test
    void test_2() throws Exception {

        mockMvc.perform(get(URI + "/get/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("get Hello"))
                .andDo(print());

    }

    @DisplayName("3. GET : hello - simple coding (Best Practice!)")
    @Test
    void test_3() throws Exception {

        mockMvc.perform(get(URI + "/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"))
                .andDo(print());

    }

    @DisplayName("4. PathVariable")
    @Test
    void test_4() throws Exception {

        String urlName = "steve";
        mockMvc.perform(get(URI + "/path-variable01/{name}", urlName))
                .andExpect(status().isOk())
                .andExpect(content().string(urlName))
                .andDo(print());

    }

    @DisplayName("5. Query Parameter 01")
    @Test
    void test_5() throws Exception {
        mockMvc.perform(get(URI + "/query-param01")
                .queryParam("name", "steve")
                .queryParam("age", "30"))
                .andExpect(status().isOk())
                .andExpect(content().string("name = steve" + "\n" + "age = 30" + "\n"))
                .andDo(print());

    }

    @DisplayName("6. Query Parameter 02 - 명시적 지정")
    @Test
    void test_6() {

    }

    @DisplayName("7. Query Parameter 03 - DTO (Best Practice!)")
    @Test
    void test_7() {

    }

}