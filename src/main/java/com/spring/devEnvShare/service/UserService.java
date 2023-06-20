package com.spring.devEnvShare.service;

import com.ctc.wstx.util.StringUtil;
import com.spring.devEnvShare.repository.CommonDao;
import com.spring.devEnvShare.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.MapUtils;
import org.thymeleaf.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    @Value("${jwt.secret}")
    private String secretKey;

    private final BCryptPasswordEncoder encoder;
    private Long expiredAtMs = 1000 * 60 * 60l; // 1시간

    private final CommonDao dao;

    public Map<String, Object> loginUser(Map paramMap) {
        Map chkMap = dao.selectOne("user.loginUser", paramMap);

        Map resultMap = new HashMap();
        if (MapUtils.isEmpty(chkMap)) {
            // 로그인 실패
            resultMap.put("result", false);
        } else {
            String encryptPw = (String) chkMap.get("USER_PW");
            boolean passwordMathes = encoder.matches(paramMap.get("pw").toString(), encryptPw);

            if (passwordMathes) {
                JwtUtil.createJwt((String) paramMap.get("id"), secretKey, expiredAtMs);
                resultMap.put("result", true);
            } else {
                resultMap.put("result", false);
            }
        }

        return resultMap;
    }

    public Map<String, Object> registUser(Map paramMap) {
        Map chkMap = dao.selectOne("user.chkUserId", paramMap);

        Map resultMap = new HashMap();
        if (((BigDecimal)chkMap.get("CNT")).intValue() == 1) {
            // userId 존재
            resultMap.put("result", false);
            return resultMap;
        } else {
            resultMap.put("result", true);
        }

        paramMap.put("pw", encoder.encode(paramMap.get("pw").toString()));
        dao.insert("user.registUser", paramMap);
        return resultMap;
    }
}