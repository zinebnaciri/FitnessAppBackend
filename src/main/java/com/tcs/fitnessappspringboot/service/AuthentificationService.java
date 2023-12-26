package com.tcs.fitnessappspringboot.service;

import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.stereotype.Service;

import com.tcs.fitnessappspringboot.Security.JwtService;
import com.tcs.fitnessappspringboot.auth.LoginRequest;
import com.tcs.fitnessappspringboot.auth.LoginResponse;
import com.tcs.fitnessappspringboot.auth.RegisterRequest;
import com.tcs.fitnessappspringboot.auth.token.Token;
import com.tcs.fitnessappspringboot.auth.token.TokenType;
import com.tcs.fitnessappspringboot.entity.User;
import com.tcs.fitnessappspringboot.repository.TokenRepository;
import com.tcs.fitnessappspringboot.repository.UserRepository;

import io.jsonwebtoken.io.IOException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthentificationService {
	  private final UserRepository repository;
	    private final TokenRepository tokenRepository;
	    private final PasswordEncoder passwordEncoder;  // Injected PasswordEncoder
	    private final JwtService jwtService;
	    private final AuthenticationManager authenticationManager;

	public LoginResponse register(RegisterRequest request) {
		var user = User.builder().firstName(request.getFirstname()).lastName(request.getLastname())
				.email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
				.dateOfBirth(request.getDateOfBirth()).gender(request.getGender()).height(request.getHeight())
				.weight(request.getWeight()).build();

		var savedUser = repository.save(user);
		var jwtToken = jwtService.generateToken(user);
		var refreshToken = jwtService.generateRefreshToken(user);
		saveUserToken(savedUser, jwtToken);
		return LoginResponse.builder().accessToken(jwtToken).refreshToken(refreshToken).build();
	}

	public LoginResponse authenticate(LoginRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		var user = repository.findByEmail(request.getEmail()).orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		var refreshToken = jwtService.generateRefreshToken(user);
		revokeAllUserTokens(user);
		saveUserToken(user, jwtToken);
		return LoginResponse.builder().accessToken(jwtToken).refreshToken(refreshToken).build();
	}

	private void saveUserToken(User personne, String jwtToken) {
		var token = Token.builder().user(personne).token(jwtToken).tokenType(TokenType.BEARER).expired(false)
				.revoked(false).build();
		tokenRepository.save(token);
	}

	private void revokeAllUserTokens(User user) {
		var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getUserId());
		if (validUserTokens.isEmpty())
			return;
		validUserTokens.forEach(token -> {
			token.setExpired(true);
			token.setRevoked(true);
		});
		tokenRepository.saveAll(validUserTokens);
	}

	public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException, JsonGenerationException, JsonMappingException, java.io.IOException {
		final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		final String refreshToken;
		final String userEmail;
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			return;
		}
		refreshToken = authHeader.substring(7);
		userEmail = jwtService.extractUsername(refreshToken);
		if (userEmail != null) {
			var user = this.repository.findByEmail(userEmail).orElseThrow();
			if (jwtService.isTokenValid(refreshToken, user)) {
				var accessToken = jwtService.generateToken(user);
				revokeAllUserTokens(user);
				saveUserToken(user, accessToken);
				var authResponse = LoginResponse.builder().accessToken(accessToken).refreshToken(refreshToken).build();
				new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
			}
		}
	}
}
