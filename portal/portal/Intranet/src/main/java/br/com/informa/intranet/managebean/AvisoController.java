package br.com.informa.intranet.managebean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.informa.intranet.core.GenericController;
import br.com.informa.intranet.utils.Contexto;
import br.com.informa.models.common.Usuario;
import br.com.informa.models.portalrh.Aviso;
import br.com.informa.models.portalrh.AvisoDestinatario;
import br.com.informa.models.portalrh.Cargo;
import br.com.informa.negocio.core.FactoryNegocio;
import br.com.informa.negocio.portal.ColaboradorNegocio;

@ManagedBean(name = "avisoController")
@ViewScoped
public class AvisoController extends GenericController<Aviso, Integer> {

	private static final long serialVersionUID = 1L;

	private List<Usuario> listSelectedUsuario;
	private List<Cargo> listSelectedCargo;
	private List<Usuario> resultado;
	private List<Cargo> resultadoCargo;

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
	
	public List<Cargo> completeTextCargo(String query) {
		resultadoCargo = FactoryNegocio.getFactory().getCargo().getCargoPorNome(query); 
		return resultadoCargo; 
	}

	@Override
	public void salvar() {
		ColaboradorNegocio entityNegocioColaborador = FactoryNegocio.getFactory().getColaborador();
		if (this.listSelectedUsuario != null) {
			if (listSelectedUsuario.size() > 0) {
				for (Usuario usuario : listSelectedUsuario) {
					AvisoDestinatario objeto = new AvisoDestinatario();
					objeto.setUsuario(usuario);
					objeto.setAviso(this.entity);
					this.entity.getListaDestinatario().add(objeto);
				}
			}
		}
		
		if (this.listSelectedCargo != null) {
			if (this.listSelectedCargo.size() > 0) {
				for (Cargo cargo : this.listSelectedCargo) {
					List<Usuario> listaUsuario = entityNegocioColaborador.getColaboradoresPorCargo(cargo.getId());
					if (listaUsuario != null) {
						if (listaUsuario.size() > 0) {
							for (Usuario usuario : listaUsuario) {
								AvisoDestinatario objeto = new AvisoDestinatario();
								objeto.setUsuario(usuario);
								objeto.setAviso(this.entity);
								this.entity.getListaDestinatario().add(objeto);
							}
						}
					}
				}
			}
		}
		super.salvar();
	}

	@Override
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

	public List<Cargo> getResultadoCargo() {
		return resultadoCargo;
	}

	public void setResultadoCargo(List<Cargo> resultadoCargo) {
		this.resultadoCargo = resultadoCargo;
	}

	public List<Cargo> getListSelectedCargo() {
		return listSelectedCargo;
	}

	public void setListSelectedCargo(List<Cargo> listSelectedCargo) {
		this.listSelectedCargo = listSelectedCargo;
	}
}
