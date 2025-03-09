package com.kass.prueba_tecnica.auth;

import io.jsonwebtoken.Jwts;

import java.security.Key;

public class TokenJwtConfig {

    public static  final Key SECRET_KEY = Jwts.SIG.HS256.key().build();

    public static final String PREFIX_TOKEN = "Bearer ";

    public static final String HEADER_AUTHORIZATION = "Authorization";
}
