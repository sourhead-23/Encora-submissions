package com.example.demo.util; 
import io.jsonwebtoken.Jwts; 
import io.jsonwebtoken.SignatureAlgorithm; 
import io.jsonwebtoken.security.Keys; 
import java.security.Key; 
import java.util.Date; 
public class JwtUtil { 
 private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); 
 // Generate Token 
 public static String generateToken(String username) { 
 return Jwts.builder() 
 .setSubject(username) 
 .setIssuer("MyApp") 
 .setIssuedAt(new Date()) 
 .setExpiration(new Date(System.currentTimeMillis() + 3600_000)) 
 .signWith(key) 
 .compact(); 
 } 
 // Validate Token 
 public static String validateToken(String token) { 
 return Jwts.parserBuilder() 
 .setSigningKey(key) 
 .build() 
 .parseClaimsJws(token) 
 .getBody() 
 .getSubject(); 
 } 
 public static String validateAndExtractUsername(String token) { 
 return Jwts.parserBuilder() 
 .setSigningKey(key) 
 .build() 
 .parseClaimsJws(token) 
 .getBody() 
 .getSubject(); 
 }
}