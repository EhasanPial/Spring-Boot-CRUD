package com.lullaby.springcurd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lullaby.springcurd.model.Employee;
import com.lullaby.springcurd.service.EmployeeService;

import jakarta.validation.Valid;

//@Controller
@RestController // @Controller+@ResponseBody
//@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService eService;

//	// 1.1 hocche default value jodi application.properties e na deya thake
//	@Value("${app.version: 1.1}")
//	private String appVersion;
//
//	@GetMapping("/version")
//	public String getApplicationVersion() {
//		return "app version: " + appVersion;
//	}

//	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees(@RequestParam int pageNumber, @RequestParam int pageSize) {
		return new ResponseEntity<List<Employee>>(eService.getEmployees(pageNumber, pageSize), HttpStatus.OK);
	}

	// Path variables
	// localhost:8080/employees/12
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long idOf) {
		return new ResponseEntity<Employee>(eService.getEmployee(idOf), HttpStatus.OK);
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(eService.saveEmployee(employee), HttpStatus.CREATED);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		employee.setId(id);
		return new ResponseEntity<Employee>(eService.updateEmployee(employee), HttpStatus.OK);
	}

	// localhost:8080/employees?id=34
	// @RequestParam("id") Long id -> jodi param and variable name same hoy tahole
	// requestParam na dileo hobe
	@DeleteMapping("employees")
	public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id) {
		eService.deleteEmployee(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);

	}

	@GetMapping("/employees/filterByName")
	public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name) {
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByName(name), HttpStatus.OK);
	}

	@GetMapping("/employees/filterByNameAndLocation")
	public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name,
			@RequestParam String location) {
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByNameAndLocation(name,location), HttpStatus.OK);
	}
	
	@GetMapping("/employees/filterByKeyword")
	public ResponseEntity<List<Employee>> getEmployeesByKeyword(@RequestParam String name) {
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByKeyword(name), HttpStatus.OK);
	}
}
