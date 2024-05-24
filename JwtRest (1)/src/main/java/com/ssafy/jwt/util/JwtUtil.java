package com.ssafy.jwt.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;


@Component
public class JwtUtil {
	
	@Value("${jwt.key}")
	private String jwtKey;
	
	@Value("${jwt.accesstoken.expiretime}")
	private Long accessTokenExpireTime;
	
	@Value("${jwt.refreshtoken.expiretime}")
	private Long refreshTokenExpireTime;
	
	public String createAccessToken(String userId) throws UnsupportedEncodingException {
		System.out.println("jwt: ");
		System.out.println(jwtKey);
		
		long currentTime = System.currentTimeMillis(); // 현재시간
		
		JwtBuilder jwtAccessTokenBuilder = Jwts.builder();
		
		jwtAccessTokenBuilder.claim("userId", userId);
		jwtAccessTokenBuilder.setIssuedAt(new Date(currentTime));
		jwtAccessTokenBuilder.setExpiration(new Date(currentTime + accessTokenExpireTime*1000));
		jwtAccessTokenBuilder.signWith(SignatureAlgorithm.HS256, jwtKey.getBytes("UTF-8"));
		
		return jwtAccessTokenBuilder.compact();
	}
	
	public String createRefreshToken(String userId) throws UnsupportedEncodingException {
		long currentTime = System.currentTimeMillis(); // 현재시간
		
		JwtBuilder jwtRefreshTokenBuilder = Jwts.builder();
		
		jwtRefreshTokenBuilder.claim("userId", userId);
		jwtRefreshTokenBuilder.setIssuedAt(new Date(currentTime));
		jwtRefreshTokenBuilder.setExpiration(new Date(currentTime + refreshTokenExpireTime*1000));
		jwtRefreshTokenBuilder.signWith(SignatureAlgorithm.HS256, jwtKey.getBytes("UTF-8"));
		
		return jwtRefreshTokenBuilder.compact();
	}
	
	public boolean validCheck(String token){
		
		try {
			System.out.println(token);
			Jwts.parser().setSigningKey(jwtKey.getBytes("UTF-8")).parseClaimsJws(token);
		} catch(Exception e) { // token을 파싱하는데 에러가 발생했다면 유효한 토큰이 아님.
			System.out.println(e);
			return false;
		}
		System.out.println("valid");
		return true;
	}

}
