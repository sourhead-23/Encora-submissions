package com.example.demo.config; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import 
org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
 
import com.example.demo.security.JwtFilter; 
@Configuration 
@EnableWebSecurity 
public class SecurityConfig { 
 private final JwtFilter jwtFilter; 
 public SecurityConfig(JwtFilter jwtFilter) { 
 this.jwtFilter = jwtFilter; 
 } 
 @Bean 
 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws 
Exception { 
 return http.csrf(csrf -> csrf.disable()) .authorizeHttpRequests(auth -> auth.requestMatchers("/api/login").permitAll().anyRequest().authenticated()) 
 .sessionManagement(sm -> 
sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) 
 .addFilterBefore(jwtFilter, 
UsernamePasswordAuthenticationFilter.class) 
 .build(); 
 } 
} 
