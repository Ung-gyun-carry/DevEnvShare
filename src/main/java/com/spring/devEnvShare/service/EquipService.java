package com.spring.devEnvShare.service;

import com.spring.devEnvShare.repository.CommonDao;
import com.spring.devEnvShare.utils.JwtUtil;
import com.spring.devEnvShare.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.MapUtils;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class EquipService {

    private final CommonDao dao;

    public List<Map<String, Object>> selectEquipCombo(Map paramMap) {
        return dao.selectList("user.selectEquipCombo", paramMap);
    }

    public List<Map<String, Object>> selectEquipCateCombo(Map paramMap) {
        return dao.selectList("user.selectEquipCateCombo", paramMap);
    }

    public Map regEquipEnv(HttpSession session, List<Map<String, Object>> paramMap) throws Exception {
        Map rtnMap = new HashMap();
        rtnMap.put("STATUS", "SUCCESS");

        Map sessionMap = (Map) session.getAttribute("USER");
        // 환경 등록 1건

         for(int i = 0; i < paramMap.size(); i++) {
            Map param = paramMap.get(i);
            param.put("USER_ID", sessionMap.get("id"));

            int regEnv = dao.insert("user.regEquipEnv", param);

            if (regEnv == 0) {
                throw new Exception("사용자 장비 환경 등록 실패");
            }
        }

        // 장비 INSERT
//        int regUserEquip = dao.insert("user.regUserEquip", paramMap);
//
//        if (regUserEquip == 0) {
//            throw new Exception("사용자 장비등록 실패");
//        }

        return rtnMap;
    }
}