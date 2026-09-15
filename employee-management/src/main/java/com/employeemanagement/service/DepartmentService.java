package com.employeemanagement.service;

import com.employeemanagement.model.Department;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DepartmentService
{
	Department addDepartment(Department department);

	Page<Department> getAllDepartments(int page, int size, String sortBy, String sortDir);
}
