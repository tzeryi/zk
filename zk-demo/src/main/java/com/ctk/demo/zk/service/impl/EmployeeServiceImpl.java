package com.ctk.demo.zk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.ctk.demo.zk.dao.EmployeeDao;
import com.ctk.demo.zk.entity.Employee;
import com.ctk.demo.zk.service.EmployeeService;

@Service("employeeService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao empDao;

	@Override
	public List<Employee> getEmpList() {
		return empDao.queryAll();
	}

	@Override
	public Employee getEmp(int empNo) {
		return empDao.get(empNo);
	}

	@Override
	public Employee addEmp(Employee emp) {
		return empDao.save(emp);
	}

	@Override
	public Employee updateEmp(Employee emp) {
		return empDao.update(emp);
	}

	@Override
	public void deleteEmp(Employee emp) {
		empDao.delete(emp);
	}

}
