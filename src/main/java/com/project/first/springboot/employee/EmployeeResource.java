package com.project.first.springboot.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javassist.tools.web.BadHttpRequest;


@RestController
//@RequestMapping(path = "/employee")
public class EmployeeResource{
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping(path="/employees")
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@GetMapping(path="/employee/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		Optional<Employee> employee = employeeRepository.findById(id);

		if (!employee.isPresent())
		throw new EmployeeNotFoundException("id-" + id);

		return employee.get();
	}

	@DeleteMapping(path="/delete/{id}")
	public void deleteEmployee(@PathVariable int id) {
		employeeRepository.deleteById(id);
	}
//	@PostMapping
//	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
//		Employee savedEmployee = employeeRepository.save(employee);
//
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(savedEmployee.getId()).toUri();
//
//		return ResponseEntity.created(location).build();
//	}
	@PostMapping(path = "/create")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@PutMapping(path = "/update/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int id) throws BadHttpRequest{

		 if (employeeRepository.existsById(id)) {
	            employee.setEmplid(id);
	            return employeeRepository.save(employee);
	        } else {
	            throw new BadHttpRequest();
	        }
		}

}


