package com.merchandise.backend.domain.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JwtService {

    private static final String SECRET_KEY = "eFXsy5Jij6Y7w3cxB65S4dvM0Pep9ttu";

    public String extractUserName(String jwt) {
        return null;
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().
                setSigningKey(getSigningKey()).
                build().
                parseClaimsJws(token).getBody();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
