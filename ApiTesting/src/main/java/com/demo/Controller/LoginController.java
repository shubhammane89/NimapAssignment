package com.demo.Controller;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RestController;

import com.demo.model.LoginRequest;

	@RestController
	public class LoginController {

	    @PostMapping("/api/login")
	    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
	        if ("siddiqshaikh1@nimapinfotech.com".equals(loginRequest.getUsername()) &&
	            "admin@123".equals(loginRequest.getPassword())) {
	            return ResponseEntity.ok("Login successful");
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	        }
	    }
	}


