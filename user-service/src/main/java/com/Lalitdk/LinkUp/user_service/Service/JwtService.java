package com.Lalitdk.LinkUp.user_service.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Lalitdk.LinkUp.user_service.Entity.User;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {
    @Value("${jwt.secretKey}")
    private String jwtSecretKey;


    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }


    public String generateAccessToken(User user){
        return Jwts.builder()
                .subject(user.getId().toString())
                .claim("email", user.getEmail())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000*60*10)) // for 10 min
                .signWith(getSecretKey())
                .compact();
    }

    


    public Long generateUserIdFromToken(String token){
        Claims claims = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return Long.valueOf(claims.getSubject());

    }
}
