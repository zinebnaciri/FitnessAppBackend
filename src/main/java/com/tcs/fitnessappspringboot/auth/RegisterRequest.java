package com.tcs.fitnessappspringboot.auth;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;
	private LocalDate dateOfBirth;
	private String gender;
	private double height;
	private double weight;

}
