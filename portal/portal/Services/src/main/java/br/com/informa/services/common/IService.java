package br.com.informa.services.common;

import java.io.Serializable;
import java.util.List;

public interface IService<T, PK extends Serializable> 
{
	void Add(T entity);
	void Update(T entity);
	void delete(T entity);
	void deleteById(PK id);
	T getById(PK pk);
	List<T> getListAll();
	Boolean validacao(T entity);
}