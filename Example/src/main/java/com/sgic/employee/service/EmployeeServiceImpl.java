package com.sgic.employee.service;

import com.sgic.employee.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sgic.employee.entities.Employee;
import com.sgic.employee.repositories.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public void saveEmployee(Employee employee) {
		SimpleMailMessage smg = new SimpleMailMessage();
		smg.setTo(employee.getEmail());
		smg.setSubject("Aaa");
		smg.setText("Bbb");

		javaMailSender.send(smg);
		employeeRepository.save(employee);
	}

	@Override
	public List<EmployeeDTO> allEmployee(){
		return employeeRepository.findAll().stream().map(this::convertToEmployeeDto).collect(Collectors.toList());
	}

	public EmployeeDTO convertToEmployeeDto(Employee employee){
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setFirstName(employee.getFirstName());
		employeeDTO.setLastName(employee.getLastName());
		return employeeDTO;
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
