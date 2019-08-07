package com.project.first.springboot.employee;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String position;

	public Employee() {
		super();
	}

	public Employee(String name, String position) {
		super();
		this.name = name;
		this.position = position;
	}

	public int getEmplid() {
		return id;
	}

	public void setEmplid(int id) {
		this.id = id;
	}

	public String getEmplname() {
		return name;
	}

	public void setEmplname(String name) {
		this.name = name;
	}

	public String getEmplposition() {
		return position;
	}

	public void setEmplposition(String position) {
		this.position = position;
	}

	
}
