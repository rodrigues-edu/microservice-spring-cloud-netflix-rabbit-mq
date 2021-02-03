package com.eduardo.auth.jwt;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class JwtTokenProvider {
	
//	security:
//		  jwt:
//		    token: 
//		      secret-key: chave_microservices
//		      expire-length: 360000  
//		      
	
	@Value("${security.jwt.token.secret-key}")
	private String secretKey;
	
	@Value("${security.jwt.token.expire-length}")
	private long expire;
	
	@Qualifier("userService")
	@Autowired
	private UserDetailsService userDetailsService;
	
	/**
	 * Método para criptografar a senha
	 */
	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}
	
	/**
	 * Método para criação do Token
	 */
	public String createToken(String username, List<String> roles) {
		Claims claims = Jwts.claims().setSubject(username);
		claims.put("roles", roles);
		
		Date now = new Date(); //Criar data de expiração
		Date validate = new Date(now.getTime() + expire);
		
		return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(validate)
				.signWith(SignatureAlgorithm.HS256, secretKey).compact();
	}
	
	/**
	 * Método para obter a autenticação quando 
	 * estiver com o token
	 */
	public Authentication getAuthentication(String token) {
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUserName(token));
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());		
	}
	
	private String getUserName(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	}
	
	/**
	 * Método para resolver o token, tirar a string inicial
	 */
	public String resolveToken(HttpServletRequest req) {
		String bearerToken = req.getHeader("Authorization");
		if(bearerToken !=null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7,bearerToken.length());
		}
		return null;
	}
	
	public boolean validateToken(String token) {
		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
			if(claims.getBody().getExpiration().before(new Date())) {
				return false;
			}
			return true;
		} catch(JwtException | IllegalArgumentException e) {
			return false;
		}
	}

}
