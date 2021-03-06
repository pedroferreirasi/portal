package br.com.informa.intranet.common;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import br.com.informa.models.common.Usuario;
import br.com.informa.models.dominio.ESexo;
import br.com.informa.models.dominio.ETipoGrupoUsuario;
import br.com.informa.negocio.common.UsuarioNegocio;
import br.com.informa.negocio.core.FactoryNegocio;
import br.com.informa.intranet.utils.Mensagens;

@ManagedBean(name = "autenticacaoController")
@SessionScoped
public class AutenticacaoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3215396402355855649L;

	private UsuarioNegocio entityService;
	private Usuario entity;
	private String paginacao;
	private String registrosPorPagina;
	private String mudarColunaDeLugarNoGrid;
	private String paginacaoSempreVisivel;
	private String fotoAvatar;

	public AutenticacaoController() {
		if (entity == null) {
			entity = new Usuario();
		}
		paginacao = "5,10,15";
		registrosPorPagina = "10";
		mudarColunaDeLugarNoGrid = "true";
		paginacaoSempreVisivel = "true";
	}

	public String login() {
		entityService = FactoryNegocio.getFactory().getUsuario();

		try {
			entity = entityService.login(entity);
			if (entity != null) {
				if (entity.getSexo() != null) {
					if (entity.getSexo().equals(ESexo.M)) {
						this.fotoAvatar = "../resources/images/avatar5.png";
					} else {
						this.fotoAvatar = "../resources/images/avatar3.png";
					}
				}
				return "pages/mainmenu?faces-redirect=true";
			}			
		} catch (Exception e) {
			Mensagens.messageError(e.getMessage());
		}

		return null;
	}

	public boolean isAdministrador() {
		// return
		return this.entity.getGrupoUsuario().getTipoGrupoUsuario().equals(ETipoGrupoUsuario.administrador);
		// return true;
	}

	public boolean isGerente() {
		return ((this.entity.getGrupoUsuario().getTipoGrupoUsuario().equals(ETipoGrupoUsuario.gerencial))
				|| (this.entity.getGrupoUsuario().getTipoGrupoUsuario().equals(ETipoGrupoUsuario.administrador)));

		// return true;
	}

	// logout event, invalidate session
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	public Usuario getEntity() {
		return entity;
	}

	public void setEntity(Usuario entity) {
		this.entity = entity;
	}

	public String getPaginacao() {
		return paginacao;
	}

	public void setPaginacao(String paginacao) {
		this.paginacao = paginacao;
	}

	public String getRegistrosPorPagina() {
		return registrosPorPagina;
	}

	public void setRegistrosPorPagina(String registrosPorPagina) {
		this.registrosPorPagina = registrosPorPagina;
	}

	public String getMudarColunaDeLugarNoGrid() {
		return mudarColunaDeLugarNoGrid;
	}

	public void setMudarColunaDeLugarNoGrid(String mudarColunaDeLugarNoGrid) {
		this.mudarColunaDeLugarNoGrid = mudarColunaDeLugarNoGrid;
	}

	public String getPaginacaoSempreVisivel() {
		return paginacaoSempreVisivel;
	}

	public void setPaginacaoSempreVisivel(String paginacaoSempreVisivel) {
		this.paginacaoSempreVisivel = paginacaoSempreVisivel;
	}

	public String getFotoAvatar() {
		return fotoAvatar;
	}

	public void setFotoAvatar(String fotoAvatar) {
		this.fotoAvatar = fotoAvatar;
	}

}
