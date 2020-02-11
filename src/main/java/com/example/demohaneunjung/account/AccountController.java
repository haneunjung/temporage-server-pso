package com.example.demohaneunjung.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @PostMapping("/sign-up")
    public String signUp() {
        return "";
    }

    @PostMapping("/sign-in")
    public String signIn() {
        return "";
    }

    @GetMapping("/test")
    public String loginTest() {
        return "TEST";
    }
}
