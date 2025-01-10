package com.jwt.example.model;

import lombok.Builder;

@Builder
public class JwtResponse {

	private String jwtToken;
	public JwtResponse(String jwtToken, String username) {
		this.jwtToken = jwtToken;
		this.username = username;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String username;
	@Override
	public String toString() {
		return "JwtResponse [jwtToken=" + jwtToken + ", username=" + username + "]";
	}
	
}
	
