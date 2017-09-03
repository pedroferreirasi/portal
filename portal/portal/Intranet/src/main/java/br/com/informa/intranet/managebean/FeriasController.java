package br.com.informa.intranet.managebean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.informa.intranet.core.GenericController;
import br.com.informa.intranet.utils.Contexto;
import br.com.informa.models.dominio.EStatusFerias;
import br.com.informa.models.portalrh.Ferias;
import br.com.informa.negocio.core.FactoryNegocio; 
 
@ManagedBean(name = "feriasController") 
@ViewScoped 
public class FeriasController extends GenericController<Ferias, Integer> { 
 
	private static final long serialVersionUID = -912029647217710627L;
	
	public FeriasController() { 
		entityService = FactoryNegocio.getFactory().getFerias(); 
		listaEntity = this.getListAllByUsuario();
	} 
 
	public void novo() 
	{ 
		super.novo();
		this.entity = new Ferias(); 		
		entity.setUsuario(Contexto.getUsuarioLogado());
		entity.setStatus(EStatusFerias.PENDENTE);
	} 
	
	public void calculaDias()
	{
		this.entity.setDias(this.entity.getDataFinal().getTime() - this.entity.getDataInicial().getTime());
	}
	
	public List<Ferias> getListAllByUsuario() {
		try {
			listaEntity = FactoryNegocio.getFactory().getFerias().getListAllByUsuario(Contexto.getUsuarioLogado().getId()); 
			return listaEntity;
		} catch (Exception e) {
			return null;
		}
	}
	
} 
