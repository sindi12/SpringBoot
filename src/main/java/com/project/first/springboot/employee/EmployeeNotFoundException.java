package com.project.first.springboot.employee;

public class EmployeeNotFoundException extends RuntimeException{

	public EmployeeNotFoundException(String exception) {
		super(exception);
	}
}
