package com.haril.restapi.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author songkg7
 * @version 1.0.0
 * @since 2021/05/19 2:09 오후
 */
@RestController
@RequestMapping("/api")
public class DeleteController {

    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable String userId, @RequestParam String account) {
        System.out.println("userId = " + userId);
        System.out.println("account = " + account);
    }

}
