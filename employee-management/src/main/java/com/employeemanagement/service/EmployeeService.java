package com.employeemanagement.service;

import com.employeemanagement.DTO.EmployeeDetailsDTO;
import com.employeemanagement.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService
{
	Page<EmployeeDetailsDTO> getAllEmployees(int page, int size, String sortBy, String sortDir);

	Employee addEmployee(Employee employee);

	String deleteEmployee(long id);
}
