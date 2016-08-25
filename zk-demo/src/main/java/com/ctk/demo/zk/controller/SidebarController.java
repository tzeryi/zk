package com.ctk.demo.zk.controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treechildren;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class SidebarController extends SelectorComposer<Component> {

	private static final long serialVersionUID = 1L;

	@Wire
	Tree fctnTree;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		Treechildren treeChildren = fctnTree.getTreechildren();
	}
}
