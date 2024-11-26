package com.frasato.rpgannotation.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.frasato.rpgannotation.models.UserModel;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    private String secret = "chave-test";

    public String generateToken(UserModel users){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("api")
                    .withSubject(users.getEmail())
                    .withExpiresAt(expirationDate())
                    .sign(algorithm);
            return token;
        }catch(JWTCreationException jwtCreationException){
            throw new RuntimeException("ERROR: can't create token for user: " + jwtCreationException);
        }
    }

    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("api")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch(JWTVerificationException jwtVerificationException){
            return null;
        }
    }

    public Instant expirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }


}
