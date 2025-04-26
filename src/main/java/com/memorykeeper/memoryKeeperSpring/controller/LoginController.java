package com.memorykeeper.memoryKeeperSpring.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LoginController {

    @GetMapping("/api/test")
    public String hello() {
        return "테스트입니다.";
    }

    @GetMapping("/api/home")
    public String home() {
        return "홈입니다.";
    }
}
