package com.thomas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.thomas.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
 
	public Employee findByName(String name);
 
}