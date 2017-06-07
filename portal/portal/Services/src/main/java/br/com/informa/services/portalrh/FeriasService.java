package br.com.informa.services.portalrh;

import java.util.List; 
import br.com.informa.models.portalrh.Ferias; 
import br.com.informa.repositories.dao.FactoryDao; 
import br.com.informa.repositories.dao.portalrh.IFeriasDao; 
 
public class FeriasService implements IFeriasService { 
 
	@Override 
	public void Add(Ferias entity) { 
		IFeriasDao entityDao = FactoryDao.getFactory().getFeriasDao(); 
		entityDao.Add(entity);		 
	} 
 
	@Override 
	public void Update(Ferias entity) { 
		IFeriasDao entityDao = FactoryDao.getFactory().getFeriasDao(); 
		entityDao.Update(entity); 
	} 
 
	@Override 
	public void delete(Ferias entity) { 
		IFeriasDao entityDao = FactoryDao.getFactory().getFeriasDao(); 
		entityDao.delete(entity);		 
	} 
 
	@Override 
	public void deleteById(Integer id) { 
		IFeriasDao entityDao = FactoryDao.getFactory().getFeriasDao(); 
		entityDao.deleteById(id);	 
	} 
 
	@Override 
	public Ferias getById(Integer pk) { 
		IFeriasDao entityDao = FactoryDao.getFactory().getFeriasDao(); 
		return entityDao.getById(pk); 
	} 
 
	@Override 
	public List<Ferias> getListAll() { 
		IFeriasDao entityDao = FactoryDao.getFactory().getFeriasDao(); 
		return entityDao.getListAll(); 
	}

	@Override
	public Boolean validacao(Ferias entity) {
		// TODO Auto-generated method stub
		return null;
	} 
} 
