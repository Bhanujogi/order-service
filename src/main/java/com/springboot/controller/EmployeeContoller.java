package com.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.Service.EmployeeService;
import com.springboot.model.Employee;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
// this is bhanu jogi

@RestController
@RequestMapping("/api")
@Tag(name = "EmployeeContoller", description = "To perform operations on employees")
public class EmployeeContoller {

	
	@Autowired
	private EmployeeService employeeService;

	
	@Operation(
			summary = "Post operations on employee",
			description = "Used to save employee object in database"
	)
	@PostMapping("/employee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {

		try {
			ResponseEntity<Employee> responseEntity = employeeService.createEmployee(employee);

			return responseEntity;
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
	@Operation(
			summary = "GET operations on employee by using student id",
			description = "Used to retrive employee object from database using student id"
	)
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("id") long id) {

		Optional<Employee> employee = employeeService.getEmpById(id);

		if (employee.isPresent()) {

			return new ResponseEntity<Employee>(employee.get(), HttpStatus.OK);
		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	
	@Operation(
			summary = "GET operations on employee",
			description = "Used to retrive employee object from database"
	)
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmp() {

		try {

			List<Employee> empList = employeeService.getAllEmp();

			return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
