/**
 * 
 */
package com.cg.neel.igrs.users.jwtconfiguration;

import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.cg.neel.igrs.users.configuration.IgrsUser;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Preeti
 * @Des This class used for create JWT Token
 */

@Component
public class JwtTokenGeneratorFilter  {

	private static final long JWT_TOKEN_VALIDITY = 360000; // Seconds

	// Generate Token for User
	// JWT Token contains -> header, payload, signature
	// Update in future
	public String generateToken(IgrsUser userDetails) {
		return doGenerateToken(new HashMap<>(), userDetails);
	}

	/**
	 * @param claims
	 * @param username
	 * @return
	 */

	private String doGenerateToken(Map<String, Object> claims, IgrsUser userDetails) {
		return Jwts.builder().setIssuer("New IGRS").setSubject("JWT Token")
				.claim("username", userDetails.getUsername())
				.claim("userId", userDetails.getUserId() )
				.claim("authorities", populateAuthoritirs(userDetails.getAuthorities()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000)) //1 hr
				.signWith(getSignUpKey()).compact();
	}

	/**
	 * @param authorities
	 * @return authorities in string form
	 */
	private String populateAuthoritirs(Collection<? extends GrantedAuthority> authorities) {
		Set<String> setAuthorities = new HashSet<>();
		for (GrantedAuthority authority : authorities) {
			setAuthorities.add(authority.getAuthority());
		}
		return String.join(",", setAuthorities);
	}

	/**
	 * @return key
	 */
	private Key getSignUpKey() {
		return new SecretKeySpec(SecurityConstants.JWT_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
	}



}
