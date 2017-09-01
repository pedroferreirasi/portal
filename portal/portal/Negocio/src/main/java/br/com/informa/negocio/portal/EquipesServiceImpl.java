package br.com.informa.negocio.portal;


import java.util.List; 
import br.com.informa.models.portalrh.Equipes; 
import br.com.informa.repositories.dao.FactoryDao; 
import br.com.informa.repositories.dao.portalrh.EquipesDao; 
 
public class EquipesServiceImpl implements EquipesService { 
 
	@Override 
	public void Add(Equipes entity) { 
		EquipesDao entityDao = FactoryDao.getFactory().getEquipesDao(); 
		entityDao.Add(entity);		 
	} 
 
	@Override 
	public void Update(Equipes entity) { 
		EquipesDao entityDao = FactoryDao.getFactory().getEquipesDao(); 
		entityDao.Update(entity); 
	} 
 
	@Override 
	public void delete(Equipes entity) { 
		EquipesDao entityDao = FactoryDao.getFactory().getEquipesDao(); 
		entityDao.delete(entity);		 
	} 
 
	@Override 
	public void deleteById(Integer id) { 
		EquipesDao entityDao = FactoryDao.getFactory().getEquipesDao(); 
		entityDao.deleteById(id);	 
	} 
 
	@Override 
	public Equipes getById(Integer pk) { 
		EquipesDao entityDao = FactoryDao.getFactory().getEquipesDao(); 
		return entityDao.getById(pk); 
	} 
 
	@Override 
	public List<Equipes> getListAll() { 
		EquipesDao entityDao = FactoryDao.getFactory().getEquipesDao(); 
		return entityDao.getListAll(); 
	}

	@Override
	public Boolean validacao(Equipes entity) {
		// TODO Auto-generated method stub
		return null;
	} 
} 
