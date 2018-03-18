package com.springexample.boot.repository.service;

import com.springexample.boot.repository.entity.Department;

public interface DepartmentService {

	Iterable<Department> findByName(String name);

}
