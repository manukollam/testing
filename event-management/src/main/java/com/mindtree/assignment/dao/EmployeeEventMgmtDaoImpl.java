package com.mindtree.assignment.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.assignment.model.Employee;

@Repository
public class EmployeeEventMgmtDaoImpl implements EmployeeEventMgmtDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void save(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
	}

	@Override
	public List<Employee> list() {
		@SuppressWarnings("unchecked")
		TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee");
	    return query.getResultList();
	}
}
