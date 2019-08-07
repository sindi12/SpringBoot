package com.project.first.springboot.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported = false)
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
