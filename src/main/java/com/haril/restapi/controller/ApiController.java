package com.haril.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

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

    // Best
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




}
