package br.com.cassunde.bean;

import java.io.Serializable;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.NodeExpandEvent;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;;

@Named
@ViewScoped
public class TreeBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private TreeNode tree;
	
	@PostConstruct
	public void init() {
		tree = new DefaultTreeNode();
		montaTree();
	}
	
	public void montaTree() {
		
		for(int i = 0; i <= 10; i++ ) {
	
			Sector sectorActual = new Sector("Sector "+i,"LocalExample");			
			new DefaultTreeNode(sectorActual, tree)
				.setChildren( Arrays.asList( new DefaultTreeNode() ) );
		}
	}

	public void expand(NodeExpandEvent expand) {

		expand.getTreeNode().getChildren().clear();
		
		for(int i = 0; i <= 10; i++ ) {
			
			Sector sectorActual = new Sector("Sector "+i + " - Child of "+expand.getTreeNode().getData(),"LocalExample");			
			new DefaultTreeNode(sectorActual, expand.getTreeNode())
				.setChildren( Arrays.asList( new CheckboxTreeNode() ) );
		}
	}
	
	public TreeNode getTree() {
		return tree;
	}

	public void setTree(TreeNode tree) {
		this.tree = tree;
	}
}
