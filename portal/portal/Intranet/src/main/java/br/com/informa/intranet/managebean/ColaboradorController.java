package br.com.informa.intranet.managebean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.informa.intranet.core.GenericController;
import br.com.informa.models.common.Usuario;
import br.com.informa.models.portalrh.Dependentes;
import br.com.informa.negocio.core.FactoryNegocio;

@ManagedBean(name = "colaboradorController")
@ViewScoped
public class ColaboradorController extends GenericController<Usuario, Integer> {

	private static final long serialVersionUID = -6576299296092551298L;
	private List<Usuario> listAniversariantes;
	private Dependentes dependente;
	List<Usuario> resultado;

	public ColaboradorController() {
		entityService = FactoryNegocio.getFactory().getColaborador();
		this.novo();
		listaEntity = this.getListAll();
		this.setWidthModal("900");
		this.setHeightModal("390");
	}
	
	public void addDepentes() {
		this.entity.setDependentes(this.dependente);
	}
	
    public List<Usuario> completeText(String query) {
    	resultado = FactoryNegocio.getFactory().getColaborador().getColaboradoresPorNome(query);    	
        return resultado;
    }

	@Override
	public void novo() {
		super.novo();
		this.entity = new Usuario();
		this.dependente = new Dependentes();
	}
	
	@Override
	public void editar(Usuario entity) {
		resultado = FactoryNegocio.getFactory().getColaborador().getColaboradoresPorNome(""); 
		super.editar(entity);
	}
	
	public List<Usuario> getAniversariantesDoMes(String mes) {
		return FactoryNegocio.getFactory().getColaborador().getAniversariantesDoMes(mes);
	}

	public List<Usuario> getListAniversariantes() {
		this.listAniversariantes = getAniversariantesDoMes("12");
		return listAniversariantes;
	}

	public void setListAniversariantes(List<Usuario> listAniversariantes) {
		this.listAniversariantes = listAniversariantes;
	}

	public Dependentes getDependente() {
		return dependente;
	}

	public void setDependente(Dependentes dependente) {
		this.dependente = dependente;
	}
}
