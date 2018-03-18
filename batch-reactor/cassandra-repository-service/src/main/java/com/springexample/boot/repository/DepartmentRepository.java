package com.springexample.boot.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.springexample.boot.repository.entity.Department;

@Repository
public interface DepartmentRepository extends CassandraRepository<Department, String> {
	
	@Query(value = "SELECT * FROM Department WHERE department_name = ?0 ALLOW FILTERING")
	Iterable<Department> findByName(String name);

}
