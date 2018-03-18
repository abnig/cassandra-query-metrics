package com.springexample.boot.repository.service;

import com.springexample.boot.repository.entity.Employee;

public interface EmployeeService {

	Iterable<Employee> findByName(String name);
}
