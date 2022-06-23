package br.com.cassunde.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.NamingException;

import org.primefaces.event.NodeExpandEvent;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import br.com.cassunde.services.SalesServices;;

@Named
@ViewScoped
public class TreeBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private TreeNode tree;
	
	@Inject
	private SalesServices salesServices;
	
	@Inject
	private UsuarioLogado usuarioLogado;

	@PostConstruct
	public void init() {
		tree = new DefaultTreeNode();
		montaTree();
		usuarioLogado.setName("jurema "+ UUID.randomUUID().toString());
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
	
	public String button() {
		System.out.println("clincando no btoao");
		return "/page?faces-redirect=true";
	}
	
	public void createData() {
		System.out.println("clincando no botão - Gerar massa");
		salesServices.createData();
	}
	
	public void getAllData() throws NamingException {
		System.out.println("clincando no botão - Obter toda a massa");
		salesServices.getAllData();
	}

	public UsuarioLogado getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(UsuarioLogado usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	
}
