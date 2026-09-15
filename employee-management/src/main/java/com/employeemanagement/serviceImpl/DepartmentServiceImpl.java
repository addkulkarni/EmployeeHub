package com.employeemanagement.serviceImpl;

import com.employeemanagement.model.Department;
import com.employeemanagement.repository.DepartmentRepository;
import com.employeemanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService
{
	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public Department addDepartment(Department department)
	{
		return departmentRepository.save(department);
	}

	@Override
	public Page<Department> getAllDepartments(int page, int size, String sortBy, String sortDir)
	{
		Sort sort;
		if(sortDir.equalsIgnoreCase("desc"))
		{
			sort = Sort.by(sortBy).descending();
		}
		else{
			sort = Sort.by(sortBy).ascending();
		}

		Pageable pageable = PageRequest.of(page, size, sort);


		return departmentRepository.findAll(pageable);
	}
}
