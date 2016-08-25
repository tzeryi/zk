package com.ctk.demo.zk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.ctk.demo.zk.dao.DepartmentDao;
import com.ctk.demo.zk.entity.Department;
import com.ctk.demo.zk.service.DepartmentService;

@Service("deptService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentDao deptDao;

	@Override
	public List<Department> getDeptList() {
		return deptDao.queryAll();
	}

	@Override
	public Department getDept(String deptNo) {
		return deptDao.get(deptNo);
	}

	@Override
	public Department addDept(Department dept) {
		return deptDao.save(dept);
	}

	@Override
	public Department updateDept(Department dept) {
		return deptDao.update(dept);
	}

	@Override
	public void deleteDept(Department dept) {
		deptDao.delete(dept);
	}

}
