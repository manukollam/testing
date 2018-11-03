package com.mindtree.assignment.service;

import java.util.List;

import com.mindtree.assignment.model.Employee;

public interface EmployeeEventMgmtService {
	void save(Employee employee);
	List<Employee> list();
}
