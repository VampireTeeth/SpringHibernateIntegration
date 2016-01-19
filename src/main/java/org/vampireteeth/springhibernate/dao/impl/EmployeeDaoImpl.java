package org.vampireteeth.springhibernate.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vampireteeth.springhibernate.dao.EmployeeDao;
import org.vampireteeth.springhibernate.entity.EmployeeEntity;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addEmployee(EmployeeEntity employee) {
		this.sessionFactory.getCurrentSession().save(employee);
	}

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		return this.sessionFactory.getCurrentSession().createQuery("from EmployeeEntity").list();
	}

	@Override
	public void deleteEmployee(Integer empId) {
		EmployeeEntity emp = (EmployeeEntity) this.sessionFactory.getCurrentSession().load(EmployeeEntity.class, empId);
		if (null != emp) {
			this.sessionFactory.getCurrentSession().delete(emp);
		}
	}

}
