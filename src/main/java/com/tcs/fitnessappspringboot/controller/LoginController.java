package com.tcs.fitnessappspringboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.fitnessappspringboot.auth.LoginRequest;
import com.tcs.fitnessappspringboot.auth.LoginResponse;

@RestController
@RequestMapping("/api")
public class LoginController {

 @PostMapping("/login")
 public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
     // Validate credentials and authenticate user (use Spring Security, for example)

     // If authentication is successful, generate a token or set a session
     String token = "dc578f73-8071-4258-bf7f-f17e5620e2b9";

     return ResponseEntity.ok(new LoginResponse(token));
 }
}
