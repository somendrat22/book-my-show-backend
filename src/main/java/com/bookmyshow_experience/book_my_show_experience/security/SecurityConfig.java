package com.bookmyshow_experience.book_my_show_experience.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return
                http.csrf().disable()
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/api/v1/user/login",
                                "/api/v1/user/register").permitAll()
                                .anyRequest().authenticated()
                )
                .build();

    }
}
