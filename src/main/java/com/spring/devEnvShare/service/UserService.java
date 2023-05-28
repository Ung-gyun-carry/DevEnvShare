package com.spring.devEnvShare.service;

import java.util.List;
import java.util.Map;

import com.spring.devEnvShare.repository.CommonDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final CommonDao dao;

    public Map<String, Object> loginUser(Map paramMap) {
        return dao.selectOne("user.loginUser", paramMap);
    }
}