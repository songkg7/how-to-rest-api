package com.haril.restapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.haril.restapi.dto.CarDto;
import com.haril.restapi.dto.PutRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author songkg7
 * @version 1.0.0
 * @since 2021/05/19 1:15 오후
 */
@AutoConfigureWebMvc
@WebMvcTest(PutController.class)
class PutControllerTest {

    private final String URL = "http://localhost:8080/api";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext wac;

    // Response 한글 깨지는 현상 - 필터를 추가해서 해결
    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print())
                .build();
    }

    private PutRequestDto getDto() {
        CarDto car1 = new CarDto("Benz", "13가 9387");
        CarDto car2 = new CarDto("Audi", "121저 1847");
        CarDto car3 = new CarDto("Volkswagen", "271오 5380");

        List<CarDto> carList = Arrays.asList(car1, car2, car3);

        PutRequestDto dto = new PutRequestDto();
        dto.setName("steve");
        dto.setAge(20);
        dto.setPhoneNumber("01011112222");
        dto.setCarList(carList);
        return dto;
    }

    @DisplayName("1. PUT - @JsonNaming")
    @Test
    void test_1() throws Exception {

        PutRequestDto dto = getDto();

        String content = objectMapper.writeValueAsString(dto);

        mockMvc.perform(put(URL + "/put02")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.phone_number").value("01011112222"))
                .andDo(print());

    }

}