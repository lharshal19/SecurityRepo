package com.jwt.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jwt.example.security.JwtAuthenticationEntrypoint;
import com.jwt.example.security.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {

	@Autowired
	private JwtAuthenticationEntrypoint jwtAuthenticationEntrypoint;

	@Autowired
	private JwtAuthenticationFilter filter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable()).authorizeRequests().requestMatchers("/test").authenticated()
				.requestMatchers("/auth/login").permitAll().anyRequest().authenticated().and()
				.exceptionHandling(ex -> ex.authenticationEntryPoint(jwtAuthenticationEntrypoint))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		return http.build();

		//		http.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable())
		//				.authorizeHttpRequests(auth -> auth.requestMatchers("/home/**").authenticated()
		//						.requestMatchers("/auth/login").permitAll().anyRequest())
		//				.exceptionHandling(ex -> ex.authenticationEntryPoint(jwtAuthenticationEntrypoint))
		//				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		//
		//		;
		//		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		//		return http.build();
	}

}
