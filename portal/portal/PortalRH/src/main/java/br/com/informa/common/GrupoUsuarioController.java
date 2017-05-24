package br.com.informa.common;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.informa.core.GenericController;
import br.com.informa.models.common.GrupoUsuario;
import br.com.informa.models.dominio.EEstadoForm;
import br.com.informa.services.core.FactoryService;

@ManagedBean(name = "grupoUsuarioController")
@RequestScoped
public class GrupoUsuarioController extends GenericController<GrupoUsuario> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 120633611625787924L;

	public GrupoUsuarioController() {
		entityService = FactoryService.getFactory().getGrupoUsuario();
		this.novo();
		listaEntity = this.getListAll();
	}
	
	public void novo()
	{	
		this.entity = new GrupoUsuario();
		this.estado = EEstadoForm.Incluir;
	}
}
