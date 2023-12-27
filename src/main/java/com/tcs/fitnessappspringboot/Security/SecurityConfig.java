package com.tcs.fitnessappspringboot.Security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.cors.CorsConfiguration;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	private JwtAuth jwtAuth;
	private AuthenticationProvider authenticationProvider;
	  @Autowired
	private LogoutHandler logoutHandler;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/public-endpoint/**").permitAll()
				.antMatchers("/api/auth/logout").authenticated()
				
				
				.and().logout().logoutUrl("/api/auth/logout").addLogoutHandler(logoutHandler)
				.logoutSuccessHandler((request, response, authentication) -> {
					SecurityContextHolder.clearContext();
					response.setStatus(HttpServletResponse.SC_OK);
				});
	/*
				.and()
	            .cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
*/
		return http.build();
	}

}
