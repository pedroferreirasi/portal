package br.com.informa.services.portalrh;

import java.util.List; 
import br.com.informa.models.portalrh.Ferias; 
import br.com.informa.repositories.dao.FactoryDao; 
import br.com.informa.repositories.dao.portalrh.FeriasDao; 
 
public class FeriasServiceImpl implements FeriasService { 
 
	@Override 
	public void Add(Ferias entity) { 
		FeriasDao entityDao = FactoryDao.getFactory().getFeriasDao(); 
		entityDao.Add(entity);		 
	} 
 
	@Override 
	public void Update(Ferias entity) { 
		FeriasDao entityDao = FactoryDao.getFactory().getFeriasDao(); 
		entityDao.Update(entity); 
	} 
 
	@Override 
	public void delete(Ferias entity) { 
		FeriasDao entityDao = FactoryDao.getFactory().getFeriasDao(); 
		entityDao.delete(entity);		 
	} 
 
	@Override 
	public void deleteById(Integer id) { 
		FeriasDao entityDao = FactoryDao.getFactory().getFeriasDao(); 
		entityDao.deleteById(id);	 
	} 
 
	@Override 
	public Ferias getById(Integer pk) { 
		FeriasDao entityDao = FactoryDao.getFactory().getFeriasDao(); 
		return entityDao.getById(pk); 
	} 
 
	@Override 
	public List<Ferias> getListAll() { 
		FeriasDao entityDao = FactoryDao.getFactory().getFeriasDao(); 
		return entityDao.getListAll(); 
	}

	@Override
	public Boolean validacao(Ferias entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ferias> getListAllByUsuario(Integer idUsuario) {
		FeriasDao entityDao = FactoryDao.getFactory().getFeriasDao();
		return entityDao.getListAllByUsuario(idUsuario);
	} 
} 
