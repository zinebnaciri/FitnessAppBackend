package com.tcs.fitnessappspringboot.entity;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "goals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long goalId;

	@ManyToOne
    @JoinColumn(name = "user_id")
	@JsonBackReference
	private User user;

	private String goalType;
	private double target;
	private LocalDate startDate;
	private LocalDate endDate;
	private double progress;
	private String status;

}
