package br.com.informa.core;

import java.io.Serializable;
import java.util.List;
import org.primefaces.context.RequestContext;
import br.com.informa.models.dominio.EEstadoForm;
import br.com.informa.services.common.IService;
import br.com.informa.utils.Mensagens;

public abstract class GenericController<T, TIPOCHAVE extends Serializable> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected T entity;
	protected List<T> listaEntity;
	protected IService<T, TIPOCHAVE> entityService;
	protected EEstadoForm estado;
	protected boolean exibeBotaoExcluir;
	protected boolean exibeBotaoEditar;
	protected boolean exibeColunaDeAcao;
	protected boolean exibeBotaoSalvar;
	protected boolean exibeBotaoCancelar;
	private boolean habilitarPesquisa;
	private String percentualGrid;
	private String widthModal;
	private String heightModal;

	public GenericController() {
		habilitarPesquisa = true;
		this.exibeBotaoExcluir = true;
		this.exibeBotaoEditar = true;
		this.exibeColunaDeAcao = true;
		this.exibeBotaoCancelar = true;
		this.exibeBotaoSalvar = true;
		percentualGrid = "100";
		estado = EEstadoForm.Nenhum;
		this.widthModal = "40%";
		this.heightModal = "40%";		
	}

	public void editar(T entity) {
		this.entity = entity;
		this.estado = EEstadoForm.Editar;
	}

	public void salvar() {
		RequestContext rcontext = RequestContext.getCurrentInstance();
		try {
			if (this.estado == EEstadoForm.Incluir) {
				entityService.Add(entity);
			} else {
				entityService.Update(entity);
			}
			Mensagens.OperacaoRealizadaComSucesso();
			this.estado = EEstadoForm.Nenhum;
			this.listaEntity = this.getListAll();
			rcontext.execute("PF('dlg').hide()");
		} catch (Exception e) {
			Mensagens.messageError(e.getMessage());
		}
	}

	public List<T> getListAll() {
		try {
			listaEntity = entityService.getListAll(); 
			return listaEntity; 
		} catch (Exception e) {
			return null;
		}
	}

	public T getById(TIPOCHAVE pk) {
		try {
			return entityService.getById(pk);
		} catch (Exception e) {
			return null;
		}
	}

	public void Add(T entity) {
		try {
			entityService.Add(entity);
		} catch (Exception e) {

		}
	}

	public void Update(T entity) {
		try {
			entityService.Update(entity);
		} catch (Exception e) {

		}
	}

	public void delete(T entity) {
		try {
			entityService.delete(entity);
			this.getListAll();
		} catch (Exception e) {

		}
	}

	public void deleteById(TIPOCHAVE pk) {
		try {
			entityService.deleteById(pk);
		} catch (Exception e) {

		}
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public T getEntity() {
		return entity;
	}

	public List<T> getListaEntity() {
		return listaEntity;
	}

	public void setListaEntity(List<T> listaEntity) {
		this.listaEntity = listaEntity;
	}

	public boolean isHabilitarPesquisa() {
		return habilitarPesquisa;
	}

	public void setHabilitarPesquisa(boolean habilitarPesquisa) {
		this.habilitarPesquisa = habilitarPesquisa;
	}

	public String getPercentualGrid() {
		return percentualGrid;
	}

	public void setPercentualGrid(String percentualGrid) {
		this.percentualGrid = percentualGrid;
	}

	public String getWidthModal() {
		return widthModal;
	}

	public void setWidthModal(String widthModal) {
		this.widthModal = widthModal;
	}

	public String getHeightModal() {
		return heightModal;
	}

	public void setHeightModal(String heightModal) {
		this.heightModal = heightModal;
	}

	public EEstadoForm getEstado() {
		return estado;
	}

	public void setEstado(EEstadoForm estado) {
		this.estado = estado;
	}

	public boolean isExibeBotaoExcluir() {
		return exibeBotaoExcluir;
	}

	public void setExibeBotaoExcluir(boolean exibeBotaoExcluir) {
		this.exibeBotaoExcluir = exibeBotaoExcluir;
	}

	public boolean isExibeBotaoEditar() {
		return exibeBotaoEditar;
	}

	public void setExibeBotaoEditar(boolean exibeBotaoEditar) {
		this.exibeBotaoEditar = exibeBotaoEditar;
	}

	public boolean isExibeColunaDeAcao() {
		return exibeColunaDeAcao;
	}

	public void setExibeColunaDeAcao(boolean exibeColunaDeAcao) {
		this.exibeColunaDeAcao = exibeColunaDeAcao;
	}

	public boolean isExibeBotaoSalvar() {
		return exibeBotaoSalvar;
	}

	public void setExibeBotaoSalvar(boolean exibeBotaoSalvar) {
		this.exibeBotaoSalvar = exibeBotaoSalvar;
	}

	public boolean isExibeBotaoCancelar() {
		return exibeBotaoCancelar;
	}

	public void setExibeBotaoCancelar(boolean exibeBotaoCancelar) {
		this.exibeBotaoCancelar = exibeBotaoCancelar;
	}

}
