package com.spring.devEnvShare.controller;

import java.util.List;
import java.util.Map;

import com.spring.devEnvShare.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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

    @GetMapping("/registerDevEnvForm")
    public String registerDevEnvForm(@RequestParam Map<String, Object> paramMap) {
        return "/registerDevEnvForm.html";
    }

    @GetMapping("/selectEquipCateCombo")
    @ResponseBody
    public List<Map<String, Object>> selectEquipCateCombo(@RequestParam Map<String, Object> paramMap) {
        return service.selectEquipCateCombo(paramMap);
    }
    @GetMapping("/selectEquipCombo")
    @ResponseBody
    public List<Map<String, Object>> selectEquipCombo(@RequestParam Map<String, Object> paramMap) {
        return service.selectEquipCombo(paramMap);
    }

    @PostMapping("/loginUser")
    @ResponseBody
    public Map<String, Object> loginUser(@RequestParam Map<String, Object> paramMap) {
        return service.loginUser(paramMap);
    }

    @PostMapping("/registUser")
    @ResponseBody
    public Map<String, Object> registUser(@RequestParam Map<String, Object> paramMap) {
        return service.registUser(paramMap);
    }
}