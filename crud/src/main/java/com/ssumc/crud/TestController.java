package com.ssumc.crud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        String createQuery = "insert into users";
        return "Hello World!";
    }


}
