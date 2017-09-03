package br.com.informa.intranet.managebean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.informa.intranet.core.GenericController;
import br.com.informa.models.dominio.EEstadoForm;
import br.com.informa.models.portalrh.Mural;
import br.com.informa.negocio.core.FactoryNegocio;
import br.com.informa.intranet.utils.Contexto;

@ManagedBean(name = "muralMB")
@ViewScoped
public class MuralMB extends GenericController<Mural, Integer> {

	private static final long serialVersionUID = 1L;

	public MuralMB() {
		entityService = FactoryNegocio.getFactory().getMural();
		listaEntity = this.getListAll();
		this.novo();
	}

	public void novo() {
		super.novo();
		this.entity = new Mural();
		this.estado = EEstadoForm.Incluir;
	}
	
	@Override
	public void salvar() {
		this.entity.setUsuario(Contexto.getUsuarioLogado());
		super.salvar();
	}
}
