package com.employeemanagement.serviceImpl;

import com.employeemanagement.DTO.EmployeeDetailsDTO;
import com.employeemanagement.model.Employee;
import com.employeemanagement.repository.EmployeeRepository;
import com.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Page<EmployeeDetailsDTO> getAllEmployees(int page, int size, String sortBy, String sortDir)
	{
		Sort sort;
		if(sortDir.equalsIgnoreCase("desc"))
		{
			sort = Sort.by(sortBy).descending();
		}
		else {
			sort = Sort.by(sortBy).ascending();
		}
		Pageable pageable = PageRequest.of(page,size,sort);
		Page<Employee> employee =  employeeRepository.findAll(pageable);
		Page<EmployeeDetailsDTO> employeeDto = employee.map(emp->{
			EmployeeDetailsDTO dto = new EmployeeDetailsDTO();
			dto.setFirstName(emp.getFirstName());
			dto.setLastName(emp.getLastName());
			dto.setContactNumber(emp.getContactNumber());
			if(emp.getDepartment()!=null)
			{
				dto.setDeaprtmentName(emp.getDepartment().getName());
			}
			return dto;
		});
		return employeeDto;
	}

	@Override
	public Employee addEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}

	@Override
	public String deleteEmployee(long id)
	{
		employeeRepository.deleteById(id);
		return "The employee with id: "+ id + " has been successfully removed from the system";
	}
}
