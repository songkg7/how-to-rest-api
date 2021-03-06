package com.haril.restapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

/**
 * @author songkg7
 * @version 1.0.0
 * @since 2021/05/19 2:21 오후
 */
@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL) // null 값은 내려주지 않는다.
public class User {
    private String name;
    private int age;
    private String phoneNumber;
    private String address;
}
