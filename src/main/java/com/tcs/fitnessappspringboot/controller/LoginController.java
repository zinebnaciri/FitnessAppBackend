package com.tcs.fitnessappspringboot.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.fitnessappspringboot.auth.LoginRequest;
import com.tcs.fitnessappspringboot.auth.LoginResponse;
import com.tcs.fitnessappspringboot.auth.RegisterRequest;
import com.tcs.fitnessappspringboot.service.AuthentificationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class LoginController {
	@Autowired
	private AuthentificationService service;

	@PostMapping("/register")
	public ResponseEntity<LoginResponse> register(@RequestBody RegisterRequest request) {
		return ResponseEntity.ok(service.register(request));
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest request) {
		return ResponseEntity.ok(service.authenticate(request));
	}

	@PostMapping("/refresh-token")
	public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
		service.refreshToken(request, response);
	}
	 @PostMapping("/logout")
	    public ResponseEntity<String> logout() {
	        // Perform logout logic

	        // Return a response indicating successful logout
	        return ResponseEntity.status(HttpStatus.OK).body("Logout successful");
	    }
}
