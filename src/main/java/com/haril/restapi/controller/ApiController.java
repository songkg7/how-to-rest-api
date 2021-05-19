package com.haril.restapi.controller;

import com.haril.restapi.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author songkg7
 * @version 1.0.0
 * @since 2021/05/19 2:17 오후
 */
@RestController
@RequestMapping("/api/best-practice")
public class ApiController {

    // TEXT
    @GetMapping("/text")
    public String text(@RequestParam String account) {
        return account;
    }

    // JSON
    // request -> object mapper -> object -> method -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user) {
        return user;
    }

    // ResponseEntity
    // @JsonInclude : null 값은 제외하고 response 를 만드는 등, 다양한 처리가 가능하다.
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
