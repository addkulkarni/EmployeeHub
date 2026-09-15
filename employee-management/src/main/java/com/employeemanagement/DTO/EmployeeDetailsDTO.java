package com.employeemanagement.DTO;

import com.employeemanagement.model.Department;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class EmployeeDetailsDTO
{
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String deaprtmentName;
}
