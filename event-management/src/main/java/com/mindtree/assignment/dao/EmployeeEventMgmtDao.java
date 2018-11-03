package com.mindtree.assignment.dao;

import java.util.List;

import com.mindtree.assignment.model.Employee;

public interface EmployeeEventMgmtDao {
	void save(Employee employee);
	List<Employee> list();
}
