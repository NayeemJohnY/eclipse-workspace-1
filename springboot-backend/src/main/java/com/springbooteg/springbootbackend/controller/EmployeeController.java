package com.springbooteg.springbootbackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbooteg.springbootbackend.exception.ResouceNotFoundException;
import com.springbooteg.springbootbackend.model.Employee;
import com.springbooteg.springbootbackend.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	// Get Employees
	@RequestMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	// Create Employee
	@RequestMapping("/addemployee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	// get Employee by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
		Employee employee =  employeeRepository.findById(id).orElseThrow(()-> new ResouceNotFoundException("Employee with id "+ id +" is not exists"));
		return ResponseEntity.ok(employee);
	}
	
	
	// update employee
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
		Employee employee =  employeeRepository.findById(id).orElseThrow(()-> new ResouceNotFoundException("Employee with id "+ id +" is not exists"));
		employee.setFirstname(employeeDetails.getFirstname());
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setLastname(employeeDetails.getLastname());
		
		Employee updatedEmployee=  employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	//Delete Employee
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee =  employeeRepository.findById(id).orElseThrow(()-> new ResouceNotFoundException("Employee with id "+ id +" is not exists"));
		employeeRepository.delete(employee);
		HashMap<String , Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

}
