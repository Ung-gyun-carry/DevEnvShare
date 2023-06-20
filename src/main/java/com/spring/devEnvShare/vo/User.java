package com.spring.devEnvShare.vo;

import lombok.Data;

@Data
public class User {
    private String user_id;
    private String user_pw;
    private String user_name;
    private String user_gender;
    private Integer user_age;
    private String user_email;
    private String creation_date;
}
