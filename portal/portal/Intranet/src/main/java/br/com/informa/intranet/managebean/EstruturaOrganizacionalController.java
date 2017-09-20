package br.com.informa.intranet.managebean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import br.com.informa.models.common.Usuario;
import br.com.informa.negocio.core.FactoryNegocio;

@ViewScoped
@ManagedBean(name = "estruturaOrganizacionalController")
public class EstruturaOrganizacionalController implements Serializable {

	private static final long serialVersionUID = 1L;

	private TreeNode root;

	public EstruturaOrganizacionalController() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		root = new DefaultTreeNode("Root", null);
		TreeNode node0 = new DefaultTreeNode("Node 0", root);
		TreeNode node1 = new DefaultTreeNode("Node 1", root);

		TreeNode node00 = new DefaultTreeNode("Node 0.0", node0);
		TreeNode node01 = new DefaultTreeNode("Node 0.1", node0);

		TreeNode node10 = new DefaultTreeNode("Node 1.0", node1);

		node1.getChildren().add(new DefaultTreeNode("Node 1.1"));
		node00.getChildren().add(new DefaultTreeNode("Node 0.0.0"));
		node00.getChildren().add(new DefaultTreeNode("Node 0.0.1"));
		node01.getChildren().add(new DefaultTreeNode("Node 0.1.0"));
		node10.getChildren().add(new DefaultTreeNode("Node 1.0.0"));
		root.getChildren().add(new DefaultTreeNode("Node 2"));
	}
	
	public void setRecursivo(TreeNode nodePai, Integer idChefia) {
		List<Usuario> listaUsuario = FactoryNegocio.getFactory().getColaborador().getColaboradoresPorChefia(idChefia);
		for (Usuario obj : listaUsuario) {
			TreeNode node = new DefaultTreeNode(obj.getNomeUsuario(), nodePai);
			setRecursivo(node, obj.getId());
		}
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

}
