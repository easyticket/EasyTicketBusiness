package com.dise.tickets.auth.filter;

import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dise.tickets.auth.service.JWTService;
import com.dise.tickets.entity.UserTicket;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager autenticationManager;
	private JWTService jwtService;
	
	@Autowired
	private JWTKey key;
	public JWTAuthenticationFilter(AuthenticationManager autenticationManager,JWTService jwtService) {
		this.autenticationManager = autenticationManager;
		setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/v1/login", "POST"));
		
		this.jwtService= jwtService;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String username = obtainUsername(request);
		String password = obtainPassword(request);

		if (username != null && password != null) {
			logger.info("User desde form-data " + username);
			logger.info("Pass desde form-data " + password);

		}else {
			UserTicket user=null;
			try {
				user = new ObjectMapper().readValue(request.getInputStream(), UserTicket.class);
				username = user.getUsername();
				password = user.getPassword();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		username = username.trim();

		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
		return autenticationManager.authenticate(authToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
	
		String token = jwtService.create(authResult);
		response.addHeader("Authorization", "Bearer " + token);

		Map<String, Object> body = new HashMap<>();

		body.put("token", token);
		body.put("user", (User) authResult.getPrincipal());
		body.put("mensaje", String.format("Hola ",((User) authResult.getPrincipal()).getUsername()));
		response.getWriter().write(new ObjectMapper().writeValueAsString(body));
		response.setStatus(200);
		response.setContentType("aplication/json");
	}

}
