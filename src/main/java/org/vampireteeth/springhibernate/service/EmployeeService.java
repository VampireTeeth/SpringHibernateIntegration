package org.vampireteeth.springhibernate.service;

import java.util.List;

import org.vampireteeth.springhibernate.entity.EmployeeEntity;

public interface EmployeeService {

	void addEmployee(EmployeeEntity employee);

	List<EmployeeEntity> getAllEmployees();

	void deleteEmployee(Integer empId);
}
