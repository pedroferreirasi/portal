package br.com.informa.intranet.managebean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.informa.intranet.core.GenericController;
import br.com.informa.intranet.utils.Contexto;
import br.com.informa.models.dominio.EEstadoForm;
import br.com.informa.models.portalrh.Aviso;
import br.com.informa.negocio.core.FactoryNegocio; 
 
@ManagedBean(name = "avisoController") 
@ViewScoped 
public class AvisoController extends GenericController<Aviso, Integer> { 
 
	private static final long serialVersionUID = 1L;

	public AvisoController() { 
		entityService = FactoryNegocio.getFactory().getAviso(); 
		this.novo(); 
		listaEntity = this.getListAll(); 
		this.setWidthModal("60%");
		this.setHeightModal("450");		
	} 
 
	public void novo() 
	{ 
  if (this.entity != null) {
    this.entity = null;
  } 
		this.entity = new Aviso(); 
		this.estado = EEstadoForm.Incluir;
		this.entity.setUsuario(Contexto.getUsuarioLogado());
	} 
} 
