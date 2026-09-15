package com.employeemanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "First name cannot be blank")
	private String firstName;
	private String lastName;
	@Email(message = "Please provide a valid email id")
	private String email;
	@NotBlank(message = "Contact Number cannot be empty")
	private String contactNumber;
	private String city;
	private String state;
	private Long salary;
	@ManyToOne()
	@JoinColumn(name = "dept_id")
	private Department department;
}