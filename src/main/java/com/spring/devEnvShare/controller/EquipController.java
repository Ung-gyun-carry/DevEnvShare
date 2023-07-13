package com.spring.devEnvShare.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.devEnvShare.service.EquipService;
import com.spring.devEnvShare.service.UserService;
import com.spring.devEnvShare.vo.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/equip")
public class EquipController {

    private final EquipService service;
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

    @PostMapping("/regEquipEnv")
    @ResponseBody
    public Map<String, Object> regEquipEnv(HttpSession session, @RequestParam Map<String, Object> paramMap) throws Exception {
        String json = paramMap.get("paramList").toString();
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> paramList = mapper.readValue(json, new TypeReference<ArrayList<Map<String, Object>>>(){});
        return service.regEquipEnv(session, paramList);
    }
}
