package com.springboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.Repository.EmployeeRepository;
import com.springboot.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public ResponseEntity<Employee> createEmployee(Employee employee) {
		
		System.out.println(employee.getFirstName()+ " " +employee.getLastName() + " " + employee.getDepartment() + " " + employee.getSalary());

		try {
			Employee _employee = employeeRepository.save(employee);

			return new ResponseEntity<Employee>(_employee, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Optional<Employee> getEmpById(long id) {
		
		Optional<Employee> employee = employeeRepository.findById(id);
		
		return employee;
	}

	@Override
	public List<Employee> getAllEmp() {

		List<Employee> empList = employeeRepository.findAll();
		
		return empList;
	}
	
	
	
}
