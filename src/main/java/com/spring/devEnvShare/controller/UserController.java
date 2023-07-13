package com.spring.devEnvShare.controller;

import java.util.List;
import java.util.Map;

import com.spring.devEnvShare.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService service;
    @GetMapping("/registerForm")
    public String registerForm() {
        return "/registerForm.html";
    }

    @PostMapping("/loginUser")
    @ResponseBody
    public Map<String, Object> loginUser(HttpSession session, @RequestParam Map<String, Object> paramMap) {
        return service.loginUser(session, paramMap);
    }

    @PostMapping("/registUser")
    @ResponseBody
    public Map<String, Object> registUser(@RequestParam Map<String, Object> paramMap) {
        return service.registUser(paramMap);
    }
}