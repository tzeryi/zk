package com.ctk.demo.zk.service;

import java.util.List;

import com.ctk.demo.zk.entity.Employee;

public interface EmployeeService {

	List<Employee> getEmpList();
	
	Employee getEmp(int empNo);
	
	Employee addEmp(Employee emp);
	
	Employee updateEmp(Employee emp);
	
	void deleteEmp(Employee emp);
}
