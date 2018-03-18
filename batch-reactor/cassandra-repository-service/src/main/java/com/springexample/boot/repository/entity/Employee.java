package com.springexample.boot.repository.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Entity
@Table("Employee")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1369225765731159431L;
	
	@PrimaryKey(value = "employee_id")
	private String employeeId;
	
	@Column(value = "employee_name")
	private String employeeName;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

}
