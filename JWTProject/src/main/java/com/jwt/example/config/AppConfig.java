package com.jwt.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jwt.example.security.JwtAuthenticationEntrypoint;
import com.jwt.example.security.JwtAuthenticationFilter;

@Configuration
public class AppConfig {



	@Bean
	public UserDetailsService userDetailsService() {

		UserDetails userDetails = User.builder().username("harsh").password(passwordEncoder().encode("123"))
				.roles("USER").build();
		UserDetails userDetails2 = User.builder().username("java").password(passwordEncoder().encode("1234"))
				.roles("USER").build();
		return new InMemoryUserDetailsManager(userDetails, userDetails2);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManger(AuthenticationConfiguration builder) throws Exception {
		return builder.getAuthenticationManager();
	}

}
