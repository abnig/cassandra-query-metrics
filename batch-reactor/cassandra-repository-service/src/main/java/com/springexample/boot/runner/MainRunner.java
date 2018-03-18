package com.springexample.boot.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springexample.boot.conf.CassandraConfiguration;
import com.springexample.boot.repository.service.DepartmentService;

@EnableAutoConfiguration
@SpringBootApplication
public class MainRunner {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CassandraConfiguration.class, args);
		DepartmentService job = ctx.getBean(DepartmentService.class);
		System.out.println(job.findByName("IT"));
	}

}