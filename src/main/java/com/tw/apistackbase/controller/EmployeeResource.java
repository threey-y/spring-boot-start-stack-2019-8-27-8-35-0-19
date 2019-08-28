package com.tw.apistackbase.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
 	List<Employee> employees = new ArrayList<Employee>(); 
 
 	@GetMapping(path = "/")
 	@ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployees() {
	 	return employees;
    }
 	
 	@PostMapping(path = "/")
 	@ResponseStatus(HttpStatus.CREATED)
 	public Employee createEmployee(@RequestBody Employee employee) {
 		employees.add(employee);
 		return employee;
 	}
 	
 	@RequestMapping(path = "/{id}")
 	public ResponseEntity<Employee> getOneEmployee(@PathVariable String id){
 		
 		for(Employee employee: employees) {
 			if(employee.getId().equals(id)) {
 				return ResponseEntity.ok(employee);
 			}
 		}
 		return new ResponseEntity(HttpStatus.NOT_FOUND);
 	}
 
}