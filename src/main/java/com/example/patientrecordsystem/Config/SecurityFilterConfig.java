package com.example.patientrecordsystem.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.patientrecordsystem.JWT.JWTAuthenticationFilter;
import com.example.patientrecordsystem.JWT.JwtAuthenticationEntryPoint;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityFilterConfig {

    private JwtAuthenticationEntryPoint point;
    private JWTAuthenticationFilter filter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        return security.csrf(csrf-> csrf.disable())
                .cors(cors-> cors.disable())
                .authorizeHttpRequests(auth->auth
                    .requestMatchers(req -> req.getServletPath().equals("/authenticate")).permitAll()
                    .requestMatchers(req -> req.getServletPath().equals("/appointments")).permitAll() // allow unauthenticated access to /api/open1 // allow unauthenticated access to /api/open2
                    .anyRequest().authenticated())
                .exceptionHandling(ex ->ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}

