package com.ctk.demo.zk.service;

import java.util.List;

import com.ctk.demo.zk.entity.Department;

public interface DepartmentService {
	List<Department> getDeptList();
	
	Department getDept(String deptNo);
	
	Department addDept(Department dept);
	
	Department updateDept(Department dept);
	
	void deleteDept(Department dept);
}
