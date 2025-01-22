package com.bookmyshow_experience.book_my_show_experience.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Value("${app.secret.key}")
    private String key;

    private final Long expirationTime = 36000000l;

    //somtechie22@gmail.com:123456
    public String generateToken(String credentials){
        return Jwts.builder()
                .setSubject(credentials)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    public String extractCredentials(String token){
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token){
            // token
            // I will extract credentials
            String credentials = this.extractCredentials(token);
            String email = credentials.split(":")[0];
            String password = credentials.split(":")[1];
            // database call
            return true;

    }
}
