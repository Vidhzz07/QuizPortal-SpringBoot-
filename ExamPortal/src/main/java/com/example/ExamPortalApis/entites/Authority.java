package com.example.ExamPortalApis.entites;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
	
	
	
	private String authString;
	
	

	public Authority(String authString) {
		this.authString = authString;
	}

	@Override
	public String getAuthority() {
	
		return authString;
	}

}
