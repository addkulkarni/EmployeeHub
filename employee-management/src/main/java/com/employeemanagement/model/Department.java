package com.employeemanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Department
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deptId;
	private String name;
	private Long capacity;
}
