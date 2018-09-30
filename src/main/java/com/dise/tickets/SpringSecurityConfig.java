package com.dise.tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dise.tickets.auth.filter.JWTAuthenticationFilter;
import com.dise.tickets.auth.filter.JWTAuthorizationFilter;
import com.dise.tickets.service.impl.JpaUserDetailService;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private JpaUserDetailService userDetailService;
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
		
		//		build.jdbcAuthentication().dataSource(dataSource)
//		.passwordEncoder(passwordEncoder)
//		.usersByUsernameQuery("")
//		.authoritiesByUsernameQuery("select u.username, a.authority from authorities a inner join user_ticket u on a.id_user = u.id where u.username =?");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.authorizeRequests().antMatchers("/v1/categories").permitAll()
		.antMatchers("/v1/user/registry").permitAll()
		.antMatchers("/v1/socialEvent").hasAuthority("ROLE_ADMIN")
		.anyRequest().authenticated()
		.antMatchers("/v1/socialEvents").hasAuthority("ROLE_ADMIN")
		.anyRequest().authenticated()
		.and()
		.addFilter(new JWTAuthenticationFilter(authenticationManager()))
		.addFilter(new JWTAuthorizationFilter(authenticationManager()))
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
