package com.dise.tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.dise.tickets.auth.filter.JWTAuthenticationFilter;
import com.dise.tickets.auth.filter.JWTAuthorizationFilter;
import com.dise.tickets.auth.service.JWTService;
import com.dise.tickets.service.impl.JpaUserDetailService;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private JpaUserDetailService userDetailService;
	
	@Autowired
	private JWTService jwtService;

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		http.authorizeRequests().antMatchers("/v1/categories").permitAll()
				.antMatchers("/v1/socialEvents/**").permitAll()
				.antMatchers("/v1/socialEvent").permitAll()
				.antMatchers("/v1/socialEventById").permitAll()
				.antMatchers("/v1/user/registry").permitAll()
				.antMatchers("/v1/ticket/create").hasAuthority("ROLE_USER").anyRequest().authenticated()
				.and()
				.addFilter(new JWTAuthenticationFilter(authenticationManager(),jwtService))
				.addFilter(new JWTAuthorizationFilter(authenticationManager(),jwtService)).csrf().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}


	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/v1/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
}
