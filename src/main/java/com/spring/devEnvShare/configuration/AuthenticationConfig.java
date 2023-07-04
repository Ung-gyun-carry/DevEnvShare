package com.spring.devEnvShare.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class AuthenticationConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                  .httpBasic()
                  .disable()// 인증을 UI가 아닌 토큰인증일 경우
                  .csrf().disable()
                  .cors().and()
                  .authorizeRequests()
                  .antMatchers("/user/**").permitAll()
                  .antMatchers(HttpMethod.POST, "api/v1/reviews").authenticated()
                  .and()
                  .sessionManagement()
                  .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // jwt사용하는 경우에 씀
                  .and()
//                  .addFilterBefore(new JwtTokenFilter)
                  .build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
