package com.carehive.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")  // Inject the secret key from application.properties
    private String secretKey;

    // Convert secret key into HMAC-SHA Key
    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey); 
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Generate JWT Token
    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours expiry
                .signWith(getSigningKey())  
                .compact();
    }

    // Extract email (username) from token
    public String extractEmail(String token) {
        return getClaims(token).getSubject();
    }

    // Validate the token
    public boolean validateToken(String token, String email) {
        return email.equals(extractEmail(token)) && !isTokenExpired(token);
    }

    // Check if the token is expired
    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }
    
    private Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey()) 
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
