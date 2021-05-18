package com.haril.restapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author songkg7
 * @version 1.0.0
 * @since 2021/05/18 10:26 오후
 */
@Data
public class PostRequest {
    private String account;
    private String password;
    private String email;
    private String address;

    @JsonProperty("phone_number")
    private String phoneNumber; // phone_number

    @JsonProperty("OTP")
    private String OTP; // camel 도 아니고 snakeCase 도 아닌 경우
}
