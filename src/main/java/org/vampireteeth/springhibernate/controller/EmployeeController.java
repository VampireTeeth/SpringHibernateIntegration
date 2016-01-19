package org.vampireteeth.springhibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.vampireteeth.springhibernate.entity.EmployeeEntity;
import org.vampireteeth.springhibernate.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String listEmployees(ModelMap map) {
		map.addAttribute("employee", new EmployeeEntity());
		map.addAttribute("employeeList", employeeService.getAllEmployees());
		return "editEmployeeList";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute(value="employee") EmployeeEntity employee, 
			BindingResult result) {
		this.employeeService.addEmployee(employee);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete/{employeeId}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
		this.employeeService.deleteEmployee(employeeId);
		return "redirect:/";
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
}
