package com.tcs.fitnessappspringboot.auth;



import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
 private String token;
 @JsonProperty("access_token")
 private String accessToken;
 @JsonProperty("refresh_token")
 private String refreshToken;
 private Long userId;



}

