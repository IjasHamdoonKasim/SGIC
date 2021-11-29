package com.sgic.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sgic.employee.utill.Utills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.sgic.employee.entities.Employee;
import com.sgic.employee.service.EmployeeService;

import javax.validation.Valid;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/addEmployee")
	public ResponseEntity<Object> createIncomingSample(@Valid @NonNull @RequestBody Employee employee) {
        if(Utills.notNullValidation(employee.getFirstName()) && Utills.notNullValidation(employee.getLastName())){
            employeeService.saveEmployee(employee);
            return ResponseEntity.ok("Saved Successfully!");
        }
        return ResponseEntity.ok("Not Saved Successfully!");
	}

	@GetMapping("/getAll")
	public List<Employee> allEmployee(){
		return employeeService.allEmployee();
	}

	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		Employee employee = employeeService.getEmployeeById(id);
		return ResponseEntity.ok(employee);
	}

	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @NonNull @RequestBody Employee employee){
		Employee empl = employeeService.updateEmployee(id, employee);
		return ResponseEntity.ok(empl);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
		return ResponseEntity.ok( employeeService.deleteEmployee(id) );
	}

}
