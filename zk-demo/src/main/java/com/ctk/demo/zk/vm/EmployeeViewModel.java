package com.ctk.demo.zk.vm;

import java.io.Serializable;

import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import com.ctk.demo.zk.service.EmployeeService;

@VariableResolver(DelegatingVariableResolver.class)
public class EmployeeViewModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@WireVariable
	EmployeeService empService;
}
