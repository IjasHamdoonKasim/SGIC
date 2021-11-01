package com.sgic.employee.service;

import com.sgic.employee.entities.Employee;

import java.util.List;

public interface EmployeeService {
	 void saveEmployee(Employee employee);
	 List allEmployee();
	 Employee getEmployeeById(Long id);
	 Employee updateEmployee(Long id, Employee employee);
	 String deleteEmployee(Long id);

}
