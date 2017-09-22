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
		root = new DefaultTreeNode("Thais", null);
		this.setRecursivo(root, 9);
	}
	
	public void setRecursivo(TreeNode nodePai, Integer idChefia) {
		List<Usuario> listaUsuario = FactoryNegocio.getFactory().getColaborador().getColaboradoresPorChefia(idChefia);
		for (Usuario obj : listaUsuario) {
			TreeNode node = new DefaultTreeNode(obj.getNomeUsuario() + "(" + obj.getCargo().getDescricao() + ")", nodePai);
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
