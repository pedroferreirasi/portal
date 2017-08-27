package br.com.informa.portalrh;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.informa.core.GenericController;
import br.com.informa.models.dominio.EEstadoForm;
import br.com.informa.models.portalrh.Mural;
import br.com.informa.services.core.FactoryService;
import br.com.informa.utils.Contexto;

@ManagedBean(name = "muralController")
@ViewScoped
public class MuralController extends GenericController<Mural, Integer> {

	private static final long serialVersionUID = 1L;

	public MuralController() {
		entityService = FactoryService.getFactory().getMural();
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
