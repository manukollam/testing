package com.mindtree.assignment.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mindtree.assignment.dao.EmployeeEventMgmtDao;
import com.mindtree.assignment.model.Employee;

@Service
public class EmployeeEventMgmtServiceImpl implements EmployeeEventMgmtService {

	@Autowired
	private EmployeeEventMgmtDao employeeEventMgmtDao;
	@Transactional
	public void save(Employee employee) {
		employeeEventMgmtDao.save(employee);
	}

	@Transactional(readOnly = true)
	public List<Employee> list() {
		return employeeEventMgmtDao.list();
	}

}
