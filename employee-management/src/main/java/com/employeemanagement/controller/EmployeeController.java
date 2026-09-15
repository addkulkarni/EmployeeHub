package com.employeemanagement.controller;

import com.employeemanagement.DTO.EmployeeDetailsDTO;
import com.employeemanagement.model.Employee;
import com.employeemanagement.service.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/employee")
public class EmployeeController
{
	private final static Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getAllEmployees")
	public ResponseEntity<Page<EmployeeDetailsDTO>> getAllEmployees(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size,@RequestParam(defaultValue = "id") String sortBy,@RequestParam(defaultValue = "desc") String sortDir)
	{
		log.info("Getting all the employees currently present in the system ");
		return new ResponseEntity<> (employeeService.getAllEmployees(page,size,sortBy,sortDir), HttpStatus.OK);
	}

	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee)
	{
		log.info("Adding the employee to the system");
		return new ResponseEntity<>(employeeService.addEmployee(employee),HttpStatus.OK);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long id )
	{
		log.info("Deleting the employee with id: "+id);
		String resultMessage = employeeService.deleteEmployee(id);
		return new ResponseEntity<>(resultMessage,HttpStatus.OK);
	}
}
