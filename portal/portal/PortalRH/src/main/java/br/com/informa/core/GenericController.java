package br.com.informa.core;

import java.io.Serializable;
import java.util.List;

import br.com.informa.models.dominio.EstadoForm;
import br.com.informa.services.common.IService;

public abstract class GenericController<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected T entity;
	protected List<T> listaEntity;
	protected IService<T, Integer> entityService;
	protected EstadoForm estado;
	private boolean habilitarPesquisa;
	private String percentualGrid;
	
	public GenericController()
	{
		habilitarPesquisa = true;
		percentualGrid = "100";
		estado = EstadoForm.Nenhum;		
	}
	
	public void salvar() 
	{		
		if (this.estado == EstadoForm.Incluir) 
		{
			this.Add(entity);
		} else {
			this.Update(entity);
		}
		this.listaEntity = this.getListAll();
	}
	
	public List<T> getListAll() {
		try 
		{			
			return entityService.getListAll();
		} catch (Exception e) 
		{
			return null;
		}
	}
	
	public T getById(Integer pk)
	{
		try 
		{			
			return entityService.getById(pk);
		} catch (Exception e) 
		{
			return null;
		}				
	}
	
	public void Add(T entity) {
		try 
		{
			entityService.Add(entity);
		} catch (Exception e) 
		{
			
		}		
	}

	public void Update(T entity) {
		try 
		{
			entityService.Update(entity);
		} catch (Exception e) 
		{
			
		}		
	}
	
	public void delete(T entity)
	{
		try 
		{
			entityService.delete(entity);
			this.getListAll();
		} catch (Exception e) 
		{
			
		}
	}
	
	public void deleteById(Integer pk)
	{
		try 
		{
			entityService.deleteById(pk);
		} catch (Exception e) 
		{
			
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


	
}
