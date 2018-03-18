package com.springexample.boot.repository.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springexample.boot.repository.EmployeeRepository;
import com.springexample.boot.repository.entity.Employee;
import com.springexample.boot.repository.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Iterable<Employee> findByName(String name) {
		return this.employeeRepository.findByName(name);
	}

}
