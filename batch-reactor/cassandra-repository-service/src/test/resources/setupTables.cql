CREATE TABLE Employee (
	employee_id text,
	employee_name text,
	PRIMARY KEY(employee_id)
);


CREATE TABLE Department (
	department_id text,
	department_name text,
	PRIMARY KEY(department_id)
);

INSERT INTO Department(department_id, department_name) VALUES('1000', 'IT');
INSERT INTO Department(department_id, department_name) VALUES('1001', 'HR');
INSERT INTO Employee(employee_id, employee_name) VALUES('1000', 'Abhinav');
INSERT INTO Employee(employee_id, employee_name) VALUES('1001', 'Ankur');
