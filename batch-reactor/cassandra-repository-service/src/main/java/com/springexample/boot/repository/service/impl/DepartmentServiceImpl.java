package com.springexample.boot.repository.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springexample.boot.repository.DepartmentRepository;
import com.springexample.boot.repository.entity.Department;
import com.springexample.boot.repository.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Iterable<Department> findByName(String name) {
		return this.departmentRepository.findByName(name);
	}

}
