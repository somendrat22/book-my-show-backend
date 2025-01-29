package com.bookmyshow_experience.book_my_show_experience.security;

import com.bookmyshow_experience.book_my_show_experience.dbresponse.AppUser;
import com.bookmyshow_experience.book_my_show_experience.service.DatabaseAPIUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Autowired
    DatabaseAPIUtil databaseAPIUtil;

    @Value("${app.secret.key}")
    private String key;

    private final Long expirationTime = 3600000000000l;

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
            System.out.println("Inside validate");
            AppUser user = databaseAPIUtil.getUserByEmail(email);
            if(user == null){
                return false;
            }
            if(!user.getPassword().equals(password)){
                return false;
            }
            return true;

    }
}
