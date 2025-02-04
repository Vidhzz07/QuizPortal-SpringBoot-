package com.example.ExamPortalApis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.ExamPortalApis.services.implementations.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig {
	
	
	    @Autowired
	    private JwtAuthenticationEntryPoint point;
	    
	    @Autowired
	    private JwtAuthenticationFilter filter;
	    
	    @Autowired
	    private UserDetailsServiceImpl userDetailsService;
	    
	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

            http.csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(requests -> requests.
                            requestMatchers("/auth/**").permitAll()
                            .requestMatchers(HttpMethod.OPTIONS).permitAll()
                            .anyRequest()
                            .authenticated())
                    .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	        return http.build();
	    }
	    
	    
	    @Bean
	    public DaoAuthenticationProvider daoAuthenticationProvider()
	    {
	    	DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
	    	
	    	daoAuthenticationProvider.setUserDetailsService(userDetailsService);
	    	daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
	    	
	    	
	    	return daoAuthenticationProvider;
	    }


}
