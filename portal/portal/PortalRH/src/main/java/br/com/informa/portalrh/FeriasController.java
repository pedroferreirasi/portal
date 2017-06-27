package br.com.informa.portalrh;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.informa.core.GenericController;
import br.com.informa.models.common.Usuario;
import br.com.informa.models.dominio.EEstadoForm;
import br.com.informa.models.dominio.EStatusFerias;
import br.com.informa.models.portalrh.Ferias;
import br.com.informa.services.core.FactoryService;
import br.com.informa.services.portalrh.FeriasService; 
 
@ManagedBean(name = "feriasController") 
@ViewScoped 
public class FeriasController extends GenericController<Ferias, Integer> { 
 
	private static final long serialVersionUID = -912029647217710627L;

	@ManagedProperty(value="#{autenticacaoController.entity}")
	protected Usuario usuarioMB;
	
	public FeriasController() { 
		entityService = FactoryService.getFactory().getFerias(); 
		listaEntity = this.getListAllByUsuario();
	} 
 
	public void novo() 
	{ 
		this.entity = new Ferias(); 
		this.estado = EEstadoForm.Incluir;		
		entity.setUsuario(this.usuarioMB);
		entity.setStatus(EStatusFerias.PENDENTE);
	} 
	
	public void calculaDias()
	{
		this.entity.setDias(this.entity.getDataFinal().getTime() - this.entity.getDataInicial().getTime());
	}
	
	public List<Ferias> getListAllByUsuario() {
		try {
			listaEntity = ((FeriasService) entityService).getListAllByUsuario(this.usuarioMB.getId()); 
			return listaEntity;
		} catch (Exception e) {
			return null;
		}
	}
	
	public void setUsuarioMB(Usuario usuarioMB) {
		this.usuarioMB = usuarioMB;
	}
	
} 
