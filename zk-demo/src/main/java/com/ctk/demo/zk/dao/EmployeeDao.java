package com.ctk.demo.zk.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ctk.demo.zk.entity.Employee;

@Repository
public class EmployeeDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Employee> queryAll() {
		Query query = em.createQuery("SELECT e FROM Employee e");
		List<Employee> result = query.getResultList();
		return result;
	}

	@Transactional(readOnly=true)
	public Employee get(int empId) {
		return em.find(Employee.class, empId);
	}

	@Transactional
	public Employee save(Employee emp) {
		em.persist(emp);
		return emp;
	}

	@Transactional
	public Employee update(Employee emp) {
		em.merge(emp);
		return emp;
	}

	@Transactional
	public void delete(Employee emp) {
		if (get(emp.getEmpNo()) != null) {
			em.remove(emp);
		}
	}
}
