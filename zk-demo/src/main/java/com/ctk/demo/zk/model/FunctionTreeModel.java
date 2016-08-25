package com.ctk.demo.zk.model;

import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;

import com.ctk.demo.zk.vo.FunctionVo;

public class FunctionTreeModel extends DefaultTreeModel<FunctionVo> {

	private static final long serialVersionUID = 1L;

	DefaultTreeNode<FunctionVo> _root;

	public FunctionTreeModel(FunctionTreeNode functionTreeNode) {
		super(functionTreeNode);
		_root = functionTreeNode;
	}

	public void add(DefaultTreeNode<FunctionVo> parent, DefaultTreeNode<FunctionVo>[] newNodes) {
		for (DefaultTreeNode<FunctionVo> newNode : newNodes) {
			parent.getChildren().add(newNode);
		}
	}

    public void insert(DefaultTreeNode<FunctionVo> parent, int indexFrom, int indexTo, DefaultTreeNode<FunctionVo>[] newNodes)
            throws IndexOutOfBoundsException {
        DefaultTreeNode<FunctionVo> stn = parent;
        for (int i = indexFrom; i <= indexTo; i++) {
            try {
                stn.getChildren().add(i, newNodes[i - indexFrom]);
            } catch (Exception exp) {
                throw new IndexOutOfBoundsException("Out of bound: " + i + " while size=" + stn.getChildren().size());
            }
        }
    }

    public void remove(DefaultTreeNode<FunctionVo> parent, int indexFrom, int indexTo) throws IndexOutOfBoundsException {
        DefaultTreeNode<FunctionVo> stn = parent;
        for (int i = indexTo; i >= indexFrom; i--) {
            try {
                stn.getChildren().remove(i);
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }
    }

    public void remove(DefaultTreeNode<FunctionVo> target) throws IndexOutOfBoundsException {
        int index = 0;
        DefaultTreeNode<FunctionVo> parent = null;
        // find the parent and index of target
        parent = dfSearchParent(_root, target);
        for (index = 0; index < parent.getChildCount(); index++) {
            if (parent.getChildAt(index).equals(target)) {
                break;
            }
        }
        remove(parent, index, index);
    }

	private DefaultTreeNode<FunctionVo> dfSearchParent(DefaultTreeNode<FunctionVo> node, DefaultTreeNode<FunctionVo> target) {
		if (node.getChildren() != null && node.getChildren().contains(target)) {
			return node;
		} else {
			int size = getChildCount(node);
			for (int i = 0; i < size; i++) {
				DefaultTreeNode<FunctionVo> parent = dfSearchParent((DefaultTreeNode<FunctionVo>) getChild(node, i),
						target);
				if (parent != null) {
					return parent;
				}
			}
		}
		return null;
	}
}
