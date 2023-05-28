package com.spring.devEnvShare.controller;

import java.util.List;
import java.util.Map;

import com.spring.devEnvShare.service.UserService;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @PostMapping("/loginUser")
    public Map<String, Object> loginUser(@RequestParam Map<String, Object> paramMap) {
        return service.loginUser(paramMap);
    }
}