package com.spring.devEnvShare.controller;

import java.util.List;
import java.util.Map;

import com.spring.devEnvShare.service.CommonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CommonController {

    private final CommonService service;

    @GetMapping("userList")
    public List<Map<String, Object>> memberList() {
        log.info("called userList!!");
        return service.userList();
    }
}