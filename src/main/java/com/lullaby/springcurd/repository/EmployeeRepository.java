package com.lullaby.springcurd.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.lullaby.springcurd.model.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>, JpaRepository<Employee, Long> {
	List<Employee> findByName(String name);

	// select * from employee where Name ="pial" and Location = "dhaka"
	List<Employee> findByNameAndLocation(String name, String location);

	// select * from employee where name LIKE "%ram%"
	List<Employee> findByNameContaining(String keyword, Sort sort);
}
