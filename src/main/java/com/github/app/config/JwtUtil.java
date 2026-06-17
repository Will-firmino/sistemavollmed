package com.github.app.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/* 
    JWT - Gerar o Token e a validação do Token
    Um token JWT possui 3 partes são separadas por ponto
    HEADERS.PAYLOAD.SIGNATURE
     - HEADERS -> tipo do token (jwt) e um algoritmo de assinatura (HS256)
     - PAYLOAD -> dados (claims) - username, ROLE.
     - SIGNATURE -> assinatura com a chave secreta - que garante que ninguem adulterou o token



*/
@Component
public class JwtUtil {
    
    @Value("${jwt.secret}")
    private String secret;
}
