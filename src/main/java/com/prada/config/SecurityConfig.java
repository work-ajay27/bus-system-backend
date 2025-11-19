package com.prada.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable()) // disable CSRF for POST requests
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/signup").permitAll() // allow signup
                .anyRequest().authenticated() // block everything else
            );

        return http.build();
    }
}
