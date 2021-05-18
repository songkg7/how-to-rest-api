package com.haril.restapi.controller;

import com.haril.restapi.dto.PutRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    public void put01(@RequestBody PutRequestDto putRequestDto) {
        System.out.println(putRequestDto);
    }

    // PUT 요청을 처리하는 방법 2 - return Object
    // Json 으로 변환되어 echo 처럼 동작하게 된다.
    @PutMapping("/put02")
    public PutRequestDto put02(@RequestBody PutRequestDto putRequestDto) {
        System.out.println("putRequestDto = " + putRequestDto);
        return putRequestDto;
    }

    // PathVariable
    @PutMapping("/put03/{userId}")
    public PutRequestDto put03(@RequestBody PutRequestDto putRequestDto, @PathVariable Long userId) {
        System.out.println("userId = " + userId);
        return putRequestDto;
    }

}
