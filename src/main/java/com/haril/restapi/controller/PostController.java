package com.haril.restapi.controller;

import com.haril.restapi.dto.PostRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author songkg7
 * @version 1.0.0
 * @package com.haril.restapi.controller
 * @name PostController.java
 * @since 2021/05/18 10:29 오후
 */

@Slf4j
@RestController
@RequestMapping("/api")
public class PostController {

    /**
     * POST 요청을 보내는 다양한 방법 1
     */
    @PostMapping("/post01")
    public void post01(@RequestBody Map<String, Object> requestData) {

        requestData.forEach((key, value) -> {
            System.out.println("entry.getKey() = " + key);
            System.out.println("entry.getValue() = " + value);
        });
    }

    // POST 요청을 보내는 다양한 방법 2 - DTO 활용
    // POST 요청을 보내는 다양한 방법 3 - 주고받는 JSON data 가 스네이크케이스와 카멜케이스로 서로 달라서 매칭이 안되는 경우 해결 방법
    // @JsonProperty 활용
    @PostMapping("/post02")
    public void post02(@RequestBody PostRequestDto requestData) {
        System.out.println(requestData);
    }


}
