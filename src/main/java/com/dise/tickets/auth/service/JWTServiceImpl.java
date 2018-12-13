package com.dise.tickets.auth.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.dise.tickets.auth.SimpleGrantedAuthorityMixin;
import com.dise.tickets.auth.filter.JWTKey;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

@Component
public class JWTServiceImpl implements JWTService {

	@Autowired
	private JWTKey key;

	@Override
	public String create(Authentication authentication) throws IOException {
		String username = ((User) authentication.getPrincipal()).getUsername();

		Collection<? extends GrantedAuthority> roles = authentication.getAuthorities();

		Claims claims = Jwts.claims();
		claims.put("authorities", new ObjectMapper().writeValueAsString(roles));

		String token = Jwts.builder().setClaims(claims).setSubject(username).signWith(key.getKp().getPrivate())
				.setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 3600L * 12L * 1000L))
				.compact();
		return token;
	}

	@Override
	public boolean validate(String token) {

		try {
			getClaims(token);
			return true;
		} catch (JwtException | IllegalArgumentException e) {
			System.out.println(e);
			return false;

		}
	}

	@Override
	public Claims getClaims(String token) {
		Claims claims = Jwts.parser().setSigningKey(key.getKp().getPrivate())
				.parseClaimsJws(token.replace("Bearer ", "")).getBody();
		return claims;
	}

	@Override
	public String getUsername(String token) {
		// TODO Auto-generated method stub
		return getClaims(token).getSubject();
	}

	@Override
	public Collection<? extends GrantedAuthority> getRoles(String token) throws IOException {
		Object roles = getClaims (token).get("authorities");
		Collection<? extends GrantedAuthority> authorities = Arrays.asList(
				new ObjectMapper()
				.addMixIn(SimpleGrantedAuthority.class, SimpleGrantedAuthorityMixin.class)
				.readValue(roles.toString().getBytes(), SimpleGrantedAuthority[].class)
				);
		return authorities;
	}

	@Override
	public String resolve(String token) {
		if(token != null && token.startsWith("Bearer ")) {
			return token.replace("Bearer ", "");
		}
		return null;
	}

}
