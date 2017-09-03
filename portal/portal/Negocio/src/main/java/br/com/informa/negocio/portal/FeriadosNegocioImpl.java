package br.com.informa.negocio.portal;


import java.util.Date;
import java.util.List; 
import br.com.informa.models.portalrh.Feriados; 
import br.com.informa.repositories.dao.FactoryDao; 
import br.com.informa.repositories.dao.portalrh.FeriadosDao; 
 
public class FeriadosNegocioImpl implements FeriadosNegocio { 
 
	@Override 
	public void Add(Feriados entity) { 
		FeriadosDao entityDao = FactoryDao.getFactory().getFeriadosDao(); 
		entityDao.Add(entity);		 
	} 
 
	@Override 
	public void Update(Feriados entity) { 
		FeriadosDao entityDao = FactoryDao.getFactory().getFeriadosDao(); 
		entityDao.Update(entity); 
	} 
 
	@Override 
	public void delete(Feriados entity) { 
		FeriadosDao entityDao = FactoryDao.getFactory().getFeriadosDao(); 
		entityDao.delete(entity);		 
	} 
 
	@Override 
	public void deleteById(Date id) { 
		FeriadosDao entityDao = FactoryDao.getFactory().getFeriadosDao(); 
		entityDao.deleteById(id);	 
	} 
 
	@Override 
	public Feriados getById(Date pk) { 
		FeriadosDao entityDao = FactoryDao.getFactory().getFeriadosDao(); 
		return entityDao.getById(pk); 
	} 
 
	@Override 
	public List<Feriados> getListAll() { 
		FeriadosDao entityDao = FactoryDao.getFactory().getFeriadosDao(); 
		return entityDao.getListAll(); 
	} 
 
	@Override
	public Boolean validacao(Feriados entity) {
		// TODO Auto-generated method stub 
		return true; 
 }
} 
