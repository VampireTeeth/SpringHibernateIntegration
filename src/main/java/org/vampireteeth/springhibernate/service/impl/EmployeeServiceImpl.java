package org.vampireteeth.springhibernate.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vampireteeth.springhibernate.dao.EmployeeDao;
import org.vampireteeth.springhibernate.entity.EmployeeEntity;
import org.vampireteeth.springhibernate.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@Transactional
	public void addEmployee(EmployeeEntity employee) {
		employeeDao.addEmployee(employee);
	}

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	@Transactional
	public void deleteEmployee(Integer empId) {
		employeeDao.deleteEmployee(empId);
	}

	public void setEmployeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
}
