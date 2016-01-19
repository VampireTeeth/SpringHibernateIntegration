package org.vampireteeth.springhibernate.dao;

import java.util.List;

import org.vampireteeth.springhibernate.entity.EmployeeEntity;

public interface EmployeeDao {

	void addEmployee(EmployeeEntity employee);
	List<EmployeeEntity> getAllEmployees();
	void deleteEmployee(Integer empId);
}
