package com.spring.devEnvShare.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CommonDao {

    private final SqlSessionTemplate session;

    public List<Map<String, Object>> selectList(String statement, Map<String, Object> parameter) {
        return session.selectList(statement, parameter);
    }

    public Map<String, Object> selectOne(String statement, Map<String, Object> parameter) {
        return session.selectOne(statement, parameter);
    }
}