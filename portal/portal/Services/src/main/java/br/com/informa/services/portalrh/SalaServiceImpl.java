package br.com.informa.services.portalrh;

import java.util.List; 
import br.com.informa.models.portalrh.Sala; 
import br.com.informa.repositories.dao.FactoryDao; 
import br.com.informa.repositories.dao.portalrh.SalaDao; 
 
public class SalaServiceImpl implements SalaService { 
 
	@Override 
	public void Add(Sala entity) { 
		SalaDao entityDao = FactoryDao.getFactory().getSalaDao(); 
		entityDao.Add(entity);		 
	} 
 
	@Override 
	public void Update(Sala entity) { 
		SalaDao entityDao = FactoryDao.getFactory().getSalaDao(); 
		entityDao.Update(entity); 
	} 
 
	@Override 
	public void delete(Sala entity) { 
		SalaDao entityDao = FactoryDao.getFactory().getSalaDao(); 
		entityDao.delete(entity);		 
	} 
 
	@Override 
	public void deleteById(Integer id) { 
		SalaDao entityDao = FactoryDao.getFactory().getSalaDao(); 
		entityDao.deleteById(id);	 
	} 
 
	@Override 
	public Sala getById(Integer pk) { 
		SalaDao entityDao = FactoryDao.getFactory().getSalaDao(); 
		return entityDao.getById(pk); 
	} 
 
	@Override 
	public List<Sala> getListAll() { 
		SalaDao entityDao = FactoryDao.getFactory().getSalaDao(); 
		return entityDao.getListAll(); 
	} 
 
	@Override
	public Boolean validacao(Sala entity) {
		// TODO Auto-generated method stub 
		return true; 
 }
} 
