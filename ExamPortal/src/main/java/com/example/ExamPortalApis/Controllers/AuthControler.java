package com.example.ExamPortalApis.Controllers;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExamPortalApis.config.JwtHelper;
import com.example.ExamPortalApis.entites.JwtRequest;
import com.example.ExamPortalApis.entites.JwtResponse;
import com.example.ExamPortalApis.entites.Role;
import com.example.ExamPortalApis.entites.User;
import com.example.ExamPortalApis.entites.UserRole;
import com.example.ExamPortalApis.services.UserService;
import com.example.ExamPortalApis.services.implementations.UserDetailsServiceImpl;

@RestController
@RequestMapping("/auth")
public class AuthControler {
	
	@Autowired
	private UserService userService;
	
	
	
	 @Autowired
	    private UserDetailsServiceImpl userDetailsService;

	    @Autowired
	    private AuthenticationManager manager;


	    @Autowired
	    private JwtHelper helper;
	    
	    
	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    private Logger logger = LoggerFactory.getLogger(AuthControler.class);


	    @PostMapping("/login")
	    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

	        this.doAuthenticate(request.getEmail(), request.getPassword());


	        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
	        String token = this.helper.generateToken(userDetails);

	        JwtResponse response = new JwtResponse();
	        response.setJwtToken(token);
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	    private void doAuthenticate(String email, String password) {

	        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
	        try {
	            manager.authenticate(authentication);


	        } catch (BadCredentialsException e) {
	            throw new BadCredentialsException(" Invalid Username or Password  !!");
	        }

	    }

	    @ExceptionHandler(BadCredentialsException.class)
	    public String exceptionHandler() {
	        return "Credentials Invalid !!";
	    }
	
	@PostMapping("/register")
	public User createUser(@RequestBody User user) throws Exception
	{
		Set<UserRole>userRoles=new HashSet<>();
		
		Role role = new Role(1L,"NORMAL");
		
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		
		userRoles.add(userRole);
		
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		
		return userService.createUser(user, userRoles);
		
	}

}
