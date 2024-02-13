package com.springboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.springboot.model.Employee;

public interface EmployeeService {

	public ResponseEntity<Employee> createEmployee(Employee employee);

	public Optional<Employee> getEmpById(long id);

	public List<Employee> getAllEmp();
	

}
