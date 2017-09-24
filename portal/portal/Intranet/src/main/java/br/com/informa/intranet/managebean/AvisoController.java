package br.com.informa.intranet.managebean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.informa.intranet.core.GenericController;
import br.com.informa.intranet.utils.Contexto;
import br.com.informa.models.common.Usuario;
import br.com.informa.models.portalrh.Aviso;
import br.com.informa.negocio.core.FactoryNegocio;

@ManagedBean(name = "avisoController")
@ViewScoped
public class AvisoController extends GenericController<Aviso, Integer> {

	private static final long serialVersionUID = 1L;

	private List<Usuario> listSelectedUsuario;
	private List<Usuario> resultado;

	public AvisoController() {
		entityService = FactoryNegocio.getFactory().getAviso();
		this.novo();
		listaEntity = this.getListAll();
		this.setWidthModal("60%");
		this.setHeightModal("510");
		this.listSelectedUsuario = new ArrayList<Usuario>();
	}
	
	public List<Usuario> completeText(String query) {
		setResultado(FactoryNegocio.getFactory().getColaborador().getColaboradoresPorNome(query)); 
		return getResultado(); 
	}

	public void novo() {
		super.novo();

		this.entity = new Aviso();
		this.entity.setUsuario(Contexto.getUsuarioLogado());
	}

	public List<Usuario> getListSelectedUsuario() {
		return listSelectedUsuario;
	}

	public void setListSelectedUsuario(List<Usuario> listSelectedUsuario) {
		this.listSelectedUsuario = listSelectedUsuario;
	}

	public List<Usuario> getResultado() {
		return resultado;
	}

	public void setResultado(List<Usuario> resultado) {
		this.resultado = resultado;
	}
}
