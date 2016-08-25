package com.ctk.demo.zk.model;

import org.zkoss.zul.DefaultTreeNode;

import com.ctk.demo.zk.vo.FunctionVo;

public class FunctionTreeNode extends DefaultTreeNode<FunctionVo> {

	private static final long serialVersionUID = 1L;

	private boolean open = false;

	public FunctionTreeNode(FunctionVo data) {
		super(data);
	}

	public FunctionTreeNode(FunctionVo data, DefaultTreeNode<FunctionVo>[] children) {
		super(data, children);
	}

	public FunctionTreeNode(FunctionVo data, DefaultTreeNode<FunctionVo>[] children, boolean open) {
		super(data, children);
		setOpen(open);
	}

    public boolean isOpen() {
        return open;
    }
 
    public void setOpen(boolean open) {
    	this.open = open;
    }
}
