package com.spring.devEnvShare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DevEnvShareApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevEnvShareApplication.class, args);
	}

}
