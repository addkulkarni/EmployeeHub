package com.employeemanagement.controller;

import com.employeemanagement.model.Department;
import com.employeemanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController
{
	@Autowired
	DepartmentService departmentService;

	@PostMapping("/addDepartment")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department)
	{
		return new ResponseEntity<>(departmentService.addDepartment(department), HttpStatus.OK);
	}

	@GetMapping("/getAllDepartments")
	public ResponseEntity<Page<Department>> getAllDepartments(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue = "deptId") String sortBy,@RequestParam(defaultValue = "asc") String sortDir)
	{
		return new ResponseEntity<>(departmentService.getAllDepartments(page,size,sortBy,sortDir),HttpStatus.OK);
	}
}
