package br.com.informa.negocio.portal;

import java.util.List;
import br.com.informa.models.portalrh.Aviso;
import br.com.informa.repositories.dao.FactoryDao;
import br.com.informa.repositories.dao.portalrh.AvisoDao; 
 
public class AvisoNegocioImpl implements AvisoNegocio { 
 
	@Override 
	public void Add(Aviso entity) { 
		AvisoDao entityDao = FactoryDao.getFactory().getAvisoDao(); 
		entityDao.Add(entity);		 
	} 
 
	@Override 
	public void Update(Aviso entity) { 
		AvisoDao entityDao = FactoryDao.getFactory().getAvisoDao(); 
		entityDao.Update(entity); 
	} 
 
	@Override 
	public void delete(Aviso entity) { 
		AvisoDao entityDao = FactoryDao.getFactory().getAvisoDao(); 
		entityDao.delete(entity);		 
	} 
 
	@Override 
	public void deleteById(Integer id) { 
		AvisoDao entityDao = FactoryDao.getFactory().getAvisoDao(); 
		entityDao.deleteById(id);	 
	} 
 
	@Override 
	public Aviso getById(Integer pk) { 
		AvisoDao entityDao = FactoryDao.getFactory().getAvisoDao(); 
		return entityDao.getById(pk); 
	} 
 
	@Override 
	public List<Aviso> getListAll() { 
		AvisoDao entityDao = FactoryDao.getFactory().getAvisoDao(); 
		return entityDao.getListAll(); 
	} 
 
	@Override
	public Boolean validacao(Aviso entity) {
		// TODO Auto-generated method stub 
		return true; 
 }
} 
