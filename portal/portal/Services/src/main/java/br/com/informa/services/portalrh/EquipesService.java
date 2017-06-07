package br.com.informa.services.portalrh;


import java.util.List; 
import br.com.informa.models.portalrh.Equipes; 
import br.com.informa.repositories.dao.FactoryDao; 
import br.com.informa.repositories.dao.portalrh.IEquipesDao; 
 
public class EquipesService implements IEquipesService { 
 
	@Override 
	public void Add(Equipes entity) { 
		IEquipesDao entityDao = FactoryDao.getFactory().getEquipesDao(); 
		entityDao.Add(entity);		 
	} 
 
	@Override 
	public void Update(Equipes entity) { 
		IEquipesDao entityDao = FactoryDao.getFactory().getEquipesDao(); 
		entityDao.Update(entity); 
	} 
 
	@Override 
	public void delete(Equipes entity) { 
		IEquipesDao entityDao = FactoryDao.getFactory().getEquipesDao(); 
		entityDao.delete(entity);		 
	} 
 
	@Override 
	public void deleteById(Integer id) { 
		IEquipesDao entityDao = FactoryDao.getFactory().getEquipesDao(); 
		entityDao.deleteById(id);	 
	} 
 
	@Override 
	public Equipes getById(Integer pk) { 
		IEquipesDao entityDao = FactoryDao.getFactory().getEquipesDao(); 
		return entityDao.getById(pk); 
	} 
 
	@Override 
	public List<Equipes> getListAll() { 
		IEquipesDao entityDao = FactoryDao.getFactory().getEquipesDao(); 
		return entityDao.getListAll(); 
	}

	@Override
	public Boolean validacao(Equipes entity) {
		// TODO Auto-generated method stub
		return null;
	} 
} 
