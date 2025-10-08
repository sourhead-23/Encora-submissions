package com.example.demo.controller; 
import com.example.demo.util.JwtUtil; 
import org.springframework.http.ResponseEntity; 
import org.springframework.security.core.Authentication; 
import org.springframework.web.bind.annotation.*;

import com.example.demo.util.JwtUtil;
@CrossOrigin(origins = "*")
@RestController 
@RequestMapping("/api") 
public class HelloController { 
 @PostMapping("/login") 
 public ResponseEntity<?> login(@RequestParam String username) { 
 String token = JwtUtil.generateToken(username); 
 return ResponseEntity.ok("Bearer " + token); 
 } 
 @GetMapping("/hello") 
 public ResponseEntity<?> hello(Authentication authentication) { 
 String username = authentication.getName(); 
 return ResponseEntity.ok("Hello, " + username + "! You are authenticated."); 
 } 
} 