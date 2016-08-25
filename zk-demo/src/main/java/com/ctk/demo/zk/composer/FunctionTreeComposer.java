package com.ctk.demo.zk.composer;

import java.util.HashMap;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.DropEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.TreeitemRenderer;
import org.zkoss.zul.Treerow;
import org.zkoss.zul.Window;

import com.ctk.demo.zk.data.FunctionList;
import com.ctk.demo.zk.model.FunctionTreeModel;
import com.ctk.demo.zk.model.FunctionTreeNode;
import com.ctk.demo.zk.service.DepartmentService;
import com.ctk.demo.zk.vo.FunctionVo;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class FunctionTreeComposer extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;

    @Wire
    private Window demoWindow;

    @Wire
    private Tree fctnTree;

    @WireVariable("deptService")
    private DepartmentService deptService;

    private FunctionTreeModel functionTreeModel;

    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        functionTreeModel = new FunctionTreeModel(new FunctionList(deptService.getDeptList()).getRoot());
        fctnTree.setItemRenderer(new FunctionTreeRenderer());
        fctnTree.setModel(functionTreeModel);
    }

    
    private final class FunctionTreeRenderer implements TreeitemRenderer<FunctionTreeNode> {

		@Override
		public void render(final Treeitem treeItem, FunctionTreeNode treeNode, int index) throws Exception {
            FunctionTreeNode ctn = treeNode;
            FunctionVo fctnVo = (FunctionVo) ctn.getData();
            Treerow dataRow = new Treerow();
            dataRow.setParent(treeItem);
            treeItem.setValue(ctn);
            treeItem.setOpen(ctn.isOpen());
 
            if (!isCategory(fctnVo)) { // Contact Row
                Hlayout hl = new Hlayout();
                //hl.appendChild(new Image("/widgets/tree/dynamic_tree/img/" + fctnVo.getProfilepic()));
                hl.appendChild(new Label(fctnVo.getName()));
                hl.setSclass("h-inline-block");
                Treecell treeCell = new Treecell();
                treeCell.appendChild(hl);
                dataRow.setDraggable("true");
                dataRow.appendChild(treeCell);
                dataRow.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
                    @Override
                    public void onEvent(Event event) throws Exception {
                        FunctionTreeNode clickedNodeValue = (FunctionTreeNode) ((Treeitem) event.getTarget().getParent())
                                .getValue();
                        Window w = new Window("ZK IM - " + ((FunctionVo) clickedNodeValue.getData()).getName(), "normal",
                                true);
                        w.setPosition("parent");
                        w.setParent(demoWindow);
                        HashMap<String, String> dataArgs = new HashMap<String, String>();
                        dataArgs.put("name", clickedNodeValue.getData().getName());
                        Executions.createComponents("/widgets/tree/dynamic_tree/dialog.zul", w, dataArgs);
                        w.doOverlapped();
                    }
                });
            } else { // Category Row
                dataRow.appendChild(new Treecell(fctnVo.getCategory()));
            }
            // Both category row and contact row can be item dropped
            dataRow.setDroppable("true");
            dataRow.addEventListener(Events.ON_DROP, new EventListener<Event>() {
                @SuppressWarnings("unchecked")
                @Override
                public void onEvent(Event event) throws Exception {
                    // The dragged target is a TreeRow belongs to an
                    // Treechildren of TreeItem.
                    Treeitem draggedItem = (Treeitem) ((DropEvent) event).getDragged().getParent();
                    FunctionTreeNode draggedValue = (FunctionTreeNode) draggedItem.getValue();
                    Treeitem parentItem = treeItem.getParentItem();
                    functionTreeModel.remove(draggedValue);
                    if (isCategory((FunctionVo) ((FunctionTreeNode) treeItem.getValue()).getData())) {
                        functionTreeModel.add((FunctionTreeNode) treeItem.getValue(),
                                new DefaultTreeNode[] { draggedValue });
                    } else {
                        int index = parentItem.getTreechildren().getChildren().indexOf(treeItem);
                        if(parentItem.getValue() instanceof FunctionTreeNode) {
                        	functionTreeModel.insert((FunctionTreeNode)parentItem.getValue(), index, index,
                                    new DefaultTreeNode[] { draggedValue });
                        }
                         
                    }
                }
            });
		}

        private boolean isCategory(FunctionVo function) {
            return function.getName() == null;
        }
    }
}
