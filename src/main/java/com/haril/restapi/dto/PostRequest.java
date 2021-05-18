package com.haril.restapi.dto;

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
}
