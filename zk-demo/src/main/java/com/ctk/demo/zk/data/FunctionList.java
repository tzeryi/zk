package com.ctk.demo.zk.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import com.ctk.demo.zk.dao.DepartmentDao;
import com.ctk.demo.zk.entity.Department;
import com.ctk.demo.zk.model.FunctionTreeNode;
import com.ctk.demo.zk.service.DepartmentService;
import com.ctk.demo.zk.vo.FunctionVo;

public class FunctionList {

	@WireVariable
	private DepartmentDao deptDao;

	@Autowired
	private DepartmentService deptService;

	private FunctionTreeNode root;

	public FunctionList(List<Department> deptList) {
		FunctionTreeNode deptNode = new FunctionTreeNode(new FunctionVo("Department"), getDeptChildren(deptList));
		FunctionTreeNode empNode = new FunctionTreeNode(new FunctionVo("Employee"));
		
		root = new FunctionTreeNode(null, new FunctionTreeNode[]{deptNode, empNode});
	}

	private FunctionTreeNode[] getDeptChildren(List<Department> deptList) {
		//List<Department> deptList = deptService.getDeptList();

		FunctionTreeNode[] deptChildren = new FunctionTreeNode[deptList.size()];

		for (int i = 0, size = deptList.size(); i < size; i++) {
			FunctionVo fctnVo = new FunctionVo("Departmnet", deptList.get(i).getDeptName() + "[" + deptList.get(i).getDeptNo() + "]");
			deptChildren[i] = new FunctionTreeNode(fctnVo);
		}

		return deptChildren;
	}

	public FunctionTreeNode getRoot() {
		return root;
	}
}
