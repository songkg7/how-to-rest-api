package com.haril.restapi.controller;

import com.haril.restapi.dto.PostRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
* @package com.haril.restapi.controller
* @name PostController.java
* @since 2021/05/18 10:29 오후
* @author songkg7
* @version 1.0.0
*/

@Slf4j
@RestController
@RequestMapping("/api")
public class PostController {

    /**
     * POST 요청을 보내는 다양한 방법 1
     */
    @PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData) {

        requestData.forEach((key, value) -> {
            System.out.println("entry.getKey() = " + key);
            System.out.println("entry.getValue() = " + value);
        });
    }

    // POST 요청을 보내는 다양한 방법 2 - DTO 활용
    @PostMapping("/post")
    public void post(@RequestBody PostRequest requestData) {
        System.out.println(requestData);
    }

}
