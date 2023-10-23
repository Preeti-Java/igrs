/**
 * 
 */
package com.cg.neel.igrs.users.jwtconfiguration;

import java.security.Key;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

/**
 * @author Preeti
 * @Des This class used for create JWT Token
 */

@Component
@Configuration
@PropertySource("classpath:igrstoken.properties")
@ConfigurationProperties(prefix ="igrstoken")
public class JwtTokenUtil {
	
	private static final long JWT_TOKEN_VALIDITY = 36000; //Seconds
	
	 @Value("${jwt.token.secret}") 
	private String secret;
	
	//Generate Token for User
	//JWT Token contains -> header, payload, signature
	// Update in future
	public String generateToken(UserDetails userDetails) {
		return doGenerateToken(new HashMap<>(), userDetails.getUsername());
	}

	/**
	 * @param claims
	 * @param username
	 * @return
	 */
	private String doGenerateToken(Map<String, Object> claims, String username) {
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(username)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(getSignUpKey())
				.compact();
	}

	/**
	 * @return key
	 */
	private Key getSignUpKey() {
		return Keys.secretKeyFor(SignatureAlgorithm.HS256);
	}

}
