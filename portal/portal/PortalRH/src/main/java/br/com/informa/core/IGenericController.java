package br.com.informa.core;

import java.io.Serializable;
import java.util.List;

public interface IGenericController<T, PK extends Serializable> {

	void Add(T entity);
	void Update(T entity);
	void delete(T entity);
	void deleteById(PK id);
	T getById(PK pk);
	List<T> getListAll();
}
