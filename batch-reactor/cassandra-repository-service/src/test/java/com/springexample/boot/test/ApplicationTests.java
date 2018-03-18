package com.springexample.boot.test;

import org.cassandraunit.spring.CassandraDataSet;
import org.cassandraunit.spring.CassandraUnitDependencyInjectionTestExecutionListener;
import org.cassandraunit.spring.EmbeddedCassandra;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.springexample.boot.repository.entity.Employee;
import com.springexample.boot.repository.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ApplicationTests.class})
@TestPropertySource(value = "test.properties")
@ComponentScan(basePackages = {"com.springexample.boot"})
@TestExecutionListeners({CassandraUnitDependencyInjectionTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
@CassandraDataSet(value= {"setupTables.cql"}, keyspace = "test")
@EmbeddedCassandra(timeout = Long.MAX_VALUE)
public class ApplicationTests {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void testFindByName() {
		Iterable<Employee> e = this.employeeService.findByName("Abhinav");
		
	}

}
