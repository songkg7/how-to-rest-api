package com.haril.restapi.controller;

import com.haril.restapi.dto.UserRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class GetController {

    /**
     * NOTE: Get 요청을 보내는 다양한 방법
     */
    @RequestMapping(path = "/get/hi", method = RequestMethod.GET)
    public String hi() {
        return "get hi";
    }

    @GetMapping(path = "/get/hello")
    public String getHello() {
        return "get Hello";
    }

    // Best Practice!
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // PathVariable
    @GetMapping("/path-variable01/{name}")
    public String pathVariable01(@PathVariable String name) {
        log.info("PathVariable : " + name);
        return name;
    }

    // PathVariable - path 와 변수명을 일치시키기 힘들 때 명시적 지정 방법
    @GetMapping("/path-variable02/{name}")
    public String pathVariable02(@PathVariable(name = "name") String pathName) {
        log.info("PathVariable : " + pathName);
        return pathName;
    }


    // Query Parameter
    // ex) http://localhost:8080/api/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping("query-param01")
    public String queryParam01(@RequestParam Map<String, String> queryParam) {
        StringBuilder sb = new StringBuilder();
        queryParam.forEach((key, value) -> {
            log.info("key : " + key);
            log.info("value : " + value);
            sb.append(key).append(" = ").append(value).append("\n");
        });

        return sb.toString();
    }

    // Query Parameter - 명시적 지정 방법
    @GetMapping("query-param02")
    public String queryParam02(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam int age) {
        System.out.println("name = " + name);
        System.out.println("email = " + email);
        System.out.println("age = " + age);
        return name + " " + email + " " + age;
    }

    // Query Parameter - DTO 활용 방법
    // @RequestParam 은 붙이지 않는다.
    // Best Practice!
    @GetMapping("query-param03")
    public UserRequestDto queryParam03(UserRequestDto userRequestDto) {
        System.out.println("userRequest.getName() = " + userRequestDto.getName());
        System.out.println("userRequest.getEmail() = " + userRequestDto.getEmail());
        System.out.println("userRequest.getAge() = " + userRequestDto.getAge());
        return userRequestDto;
    }

}
