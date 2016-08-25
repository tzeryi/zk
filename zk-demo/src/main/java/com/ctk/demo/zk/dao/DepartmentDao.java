package com.ctk.demo.zk.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ctk.demo.zk.entity.Department;

@Repository("deptDao")
public class DepartmentDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Department> queryAll() {
		Query query = em.createQuery("SELECT d FROM Department d");
		List<Department> result = query.getResultList();
		return result;
	}

	@Transactional
	public Department get(String deptNo) {
		Department dept = em.find(Department.class, deptNo);
		return dept;
	}

	@Transactional
	public Department save(Department dept) {
		em.persist(dept);
		return dept;
	}

	@Transactional
	public Department update(Department dept) {
		em.merge(dept);
		return dept;
	}

	@Transactional
	public void delete(Department dept) {
		if (get(dept.getDeptNo()) !=  null) {
			em.remove(dept);
		}
	}
}
