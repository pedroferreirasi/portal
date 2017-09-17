package br.com.informa.negocio.core;

import java.io.Serializable;
import java.util.List;

public interface INegocio<T, PK extends Serializable> {
	void Add(T entity);
	void Update(T entity);
	void delete(T entity);
	void deleteById(PK pk);
	T getById(PK pk);
	List<T> getListAll();
	Boolean validacao(T entity);
}
