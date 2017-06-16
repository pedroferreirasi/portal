package br.com.informa.portalrh;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.informa.core.GenericController;
import br.com.informa.models.dominio.EEstadoForm;
import br.com.informa.models.dominio.EStatusFerias;
import br.com.informa.models.portalrh.Ferias;
import br.com.informa.services.core.FactoryService;
import br.com.informa.services.portalrh.FeriasService;
import br.com.informa.utils.Contexto; 
 
@ManagedBean(name = "feriasController") 
@ViewScoped 
public class FeriasController extends GenericController<Ferias> { 
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -912029647217710627L;

	public FeriasController() { 
		entityService = FactoryService.getFactory().getFerias(); 
		listaEntity = this.getListAllByUsuario();
	} 
 
	public void novo() 
	{ 
		this.entity = new Ferias(); 
		this.estado = EEstadoForm.Incluir;
		entity.setUsuario(Contexto.getUsuarioLogoado());
		entity.setStatus(EStatusFerias.PENDENTE);
	} 
	
	public void calculaDias()
	{
		this.entity.setDias(this.entity.getDataFinal().getTime() - this.entity.getDataInicial().getTime());
	}
	
	public List<Ferias> getListAllByUsuario() {
		try {
			listaEntity = ((FeriasService) entityService).getListAllByUsuario(Contexto.getUsuarioLogoado().getId()); 
			return listaEntity;
		} catch (Exception e) {
			return null;
		}
	}
} 
