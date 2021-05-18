package com.haril.restapi.controller;

import com.haril.restapi.dto.PutRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songkg7
 * @version 1.0.0
 * @since 2021/05/18 10:45 오후
 */

@Slf4j
@RestController
@RequestMapping("/api")
public class PutController {

    // PUT 요청을 처리하는 방법 1
    // PUT 은 POST 와 거의 같다.
    // @JsonNaming 의 활용
    @PutMapping("/put01")
    public void put01(@RequestBody PutRequest putRequest) {
        System.out.println(putRequest);
    }

}