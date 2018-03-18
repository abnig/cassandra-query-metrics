package com.springexample.boot.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.springexample.boot.repository.entity.Employee;

@Repository
public interface EmployeeRepository extends CassandraRepository<Employee, String> {
	
	@Query(value = "SELECT * FROM Employee WHERE employee_name = ?0 ALLOW FILTERING")
	Iterable<Employee> findByName(String name);
}
