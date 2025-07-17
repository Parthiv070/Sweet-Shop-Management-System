package com.sweetshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF for all methods
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**", "/h2-console/**").permitAll()  // ✅ Allow all methods under /api
                        .anyRequest().authenticated()
                )
                .headers(headers -> headers.frameOptions(frame -> frame.disable()));  // Optional for H2 Console

        return http.build();
    }
}
