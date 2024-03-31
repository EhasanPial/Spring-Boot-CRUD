package com.lullaby.springcurd.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.lullaby.springcurd.model.Employee;

public interface EmployeeService {
	List<Employee> getEmployees(int pageNumber, int pageSize);
	Employee saveEmployee(Employee employee);
	Employee getEmployee(Long id);
	void deleteEmployee(Long id);
	Employee updateEmployee(Employee employee);
	List<Employee> getEmployeesByName(String name);
	List<Employee> getEmployeesByNameAndLocation(String name, String location);
	List<Employee> getEmployeesByKeyword(String name);
}
