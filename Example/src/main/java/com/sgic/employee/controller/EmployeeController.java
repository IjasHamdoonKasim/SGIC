package com.sgic.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sgic.employee.entities.Employee;
import com.sgic.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/addEmployee")
	public ResponseEntity<Object> createIncomingSample(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return ResponseEntity.ok("Saved Successfully!");
	}

	@GetMapping("/getAll")
	public List<Employee> allEmployee(){
		return employeeService.allEmployee();
	}

	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Object> getEmployeeById(@PathVariable Long id){
		employeeService.getEmployeeById(id);
	}


}
