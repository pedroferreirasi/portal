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
	private String widthModal;
	private String heightModal;
	private String tituloTelaDeCadastro;
	private Usuario entity;
	private boolean exibeBotaoSalvar;
	private boolean exibeBotaoCancelar;	

	public EstruturaOrganizacionalController() {
		this.widthModal = "600";
		this.heightModal = "280";
		this.exibeBotaoCancelar = false;
		this.exibeBotaoSalvar = false;
	}

	@PostConstruct
	public void init() {;
		root = new DefaultTreeNode(new Usuario(), null);
		this.setRecursivo(root, 8);
	}
	
	public void setRecursivo(TreeNode nodePai, Integer idChefia) {
		List<Usuario> listaUsuario = FactoryNegocio.getFactory().getColaborador().getColaboradoresPorChefia(idChefia);
		for (Usuario obj : listaUsuario) {
			TreeNode node = new DefaultTreeNode(obj, nodePai);
			setRecursivo(node, obj.getId());
		}
	}
	
	public void editar(Usuario entity) {
		this.entity = entity;
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public String getWidthModal() {
		return widthModal;
	}

	public void setWidthModal(String widthModal) {
		this.widthModal = widthModal;
	}

	public String getHeightModal() {
		return heightModal;
	}

	public void setHeightModal(String heightModal) {
		this.heightModal = heightModal;
	}

	public String getTituloTelaDeCadastro() {
		return tituloTelaDeCadastro;
	}

	public void setTituloTelaDeCadastro(String tituloTelaDeCadastro) {
		this.tituloTelaDeCadastro = tituloTelaDeCadastro;
	}

	public Usuario getEntity() {
		return entity;
	}

	public void setEntity(Usuario entity) {
		this.entity = entity;
	}

	public boolean isExibeBotaoSalvar() {
		return exibeBotaoSalvar;
	}

	public void setExibeBotaoSalvar(boolean exibeBotaoSalvar) {
		this.exibeBotaoSalvar = exibeBotaoSalvar;
	}

	public boolean isExibeBotaoCancelar() {
		return exibeBotaoCancelar;
	}

	public void setExibeBotaoCancelar(boolean exibeBotaoCancelar) {
		this.exibeBotaoCancelar = exibeBotaoCancelar;
	}

}
