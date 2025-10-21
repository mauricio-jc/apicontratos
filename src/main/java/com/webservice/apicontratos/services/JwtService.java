package com.webservice.apicontratos.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.webservice.apicontratos.exceptions.InternalServerErrorException;

@Service
public class JwtService {
	@Value("${api.jwt.secret}")
	private String secret;
	
	private Instant expiresAt = LocalDateTime.now().plusDays(30).toInstant(ZoneOffset.of("-03:00"));
	
	public String generateToken(String username) {
		try {
		    Algorithm algorithm = Algorithm.HMAC256(secret);
		    String token = JWT.create()
		    				.withIssuer("auth-api")
		    				.withSubject(username)
		    				.withExpiresAt(expiresAt)
		    				.sign(algorithm);
		    
		    return token;
		}
		catch (JWTCreationException e) {
			throw new InternalServerErrorException("Error while generating token", e);
		}
	}
	
	public String validateTokenAndGetUsername(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			
			return JWT.require(algorithm)
					.withIssuer("auth-api")
					.build()
					.verify(token)
					.getSubject();
		}
		catch (JWTVerificationException e) {
			return null;
		}
	}
}
