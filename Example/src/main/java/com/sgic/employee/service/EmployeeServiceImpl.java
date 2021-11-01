package com.sgic.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.employee.entities.Employee;
import com.sgic.employee.repositories.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
@Autowired
EmployeeRepository employeeRepository;

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public List allEmployee(){
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id){
		Employee employee = employeeRepository.findById(id).orElseThrow(null);
		return employee;
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee){
		Employee empl = employeeRepository.findById(id).orElseThrow(null);
		empl.setEmail(employee.getEmail());
		empl.setFirstName(employee.getFirstName());
		empl.setLastName(employee.getLastName());
		employeeRepository.save(empl);
		return empl;

	}

	@Override
	public String deleteEmployee(Long id){
		Employee employee = employeeRepository.findById(id).orElseThrow(null);
		employeeRepository.delete(employee);

		return "SUCCESSFULLY DELETED";
	}


}
