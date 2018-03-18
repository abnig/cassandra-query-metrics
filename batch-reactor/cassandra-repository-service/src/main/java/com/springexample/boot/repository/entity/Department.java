package com.springexample.boot.repository.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Entity
@Table("Department")
public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5656940536801568382L;

	@PrimaryKey(value = "department_id")
	private String departmentId;
	
	@Column(value = "department_name")
	private String departmentName;

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
}
