package com.dise.tickets.auth.filter;

import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.dise.tickets.auth.SimpleGrantedAuthorityMixin;
import com.dise.tickets.auth.service.JWTService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter{

	private JWTService jwtService;

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager,JWTService jwtService) {
		super(authenticationManager);
		this.jwtService= jwtService;

	}
	
	@Autowired
	private JWTKey key;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {


		String header = request.getHeader("Authorization");

		if (!requiresAuthentication(header)) {
			chain.doFilter(request, response);
			return;
		}
		
		
		UsernamePasswordAuthenticationToken authentication =null;
		if(jwtService.validate(header)) {
			authentication = new UsernamePasswordAuthenticationToken(jwtService.getUsername(header), null,jwtService.getRoles(header));
		}
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);
		
	}
	
	protected boolean requiresAuthentication(String header){
		if (header == null || !header.startsWith("Bearer ")) {

			return false ;
		}
		return true;
	}

}
