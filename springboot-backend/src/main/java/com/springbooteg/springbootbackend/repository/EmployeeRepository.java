package com.springbooteg.springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbooteg.springbootbackend.model.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}
