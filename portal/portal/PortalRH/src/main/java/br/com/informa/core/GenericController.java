package br.com.informa.core;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import br.com.informa.models.dominio.EEstadoForm;
import br.com.informa.services.common.IService;

public abstract class GenericController<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected T entity;
	protected List<T> listaEntity;
	protected IService<T, Integer> entityService;
	protected EEstadoForm estado;
	private boolean habilitarPesquisa;
	private String percentualGrid;
	private String widthModal;
	private String heightModal;

	public GenericController() {
		habilitarPesquisa = true;
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
			this.estado = EEstadoForm.Nenhum;
			this.listaEntity = this.getListAll();
			rcontext.execute("PF('dlg').hide()");
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
		}
	}

	public List<T> getListAll() {
		try {
			return entityService.getListAll();
		} catch (Exception e) {
			return null;
		}
	}

	public T getById(Integer pk) {
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

	public void deleteById(Integer pk) {
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

}
