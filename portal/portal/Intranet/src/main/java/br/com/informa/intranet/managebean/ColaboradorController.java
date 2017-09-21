package br.com.informa.intranet.managebean;

import java.util.ArrayList;
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
	private String nomeChefeAutoComplete;
	private List<Usuario> resultado;

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

	public List<String> completeText(String query) {
		setResultado(FactoryNegocio.getFactory().getColaborador().getColaboradoresPorNome(query));

		List<String> strings = new ArrayList<>(getResultado().size());

		for (Usuario usuario : getResultado()) {
			strings.add(usuario.getNomeCompleto());
		}

		return strings;
	}

	@Override
	public void novo() {
		super.novo();
		this.entity = new Usuario();
		this.dependente = new Dependentes();
	}

	@Override
	public void editar(Usuario entity) {
		if (entity.getDadosProfissionais().getChefia() != null) {
			this.nomeChefeAutoComplete = FactoryNegocio.getFactory().getColaborador()
					.getById(entity.getDadosProfissionais().getChefia()).getNomeCompleto();
		} else {
			this.nomeChefeAutoComplete = "";
		}
		super.editar(entity);
	}

	@Override
	public void salvar() {
		if (this.nomeChefeAutoComplete != null) {
			resultado = FactoryNegocio.getFactory().getColaborador().getColaboradoresPorNome(this.nomeChefeAutoComplete);
			for (Usuario o : this.resultado) {
				if (o.getNomeCompleto().equals(this.nomeChefeAutoComplete)) {
					this.entity.getDadosProfissionais().setChefia(o.getId());
					break;
				}
			}
		} else {
			this.entity.getDadosProfissionais().setChefia(null);
		}
		super.salvar();
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

	public String getNomeChefeAutoComplete() {
		return nomeChefeAutoComplete;
	}

	public void setNomeChefeAutoComplete(String nomeChefeAutoComplete) {
		this.nomeChefeAutoComplete = nomeChefeAutoComplete;
	}

	public List<Usuario> getResultado() {
		return resultado;
	}

	public void setResultado(List<Usuario> resultado) {
		this.resultado = resultado;
	}
}
